package com.alorma.intendencia.presenter;

import android.support.annotation.NonNull;
import com.alorma.intendencia.data.usecase.GetMenusUseCase;
import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.usecase.AddMenuUseCase;
import com.alorma.intendencia.injector.PerActivity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

@PerActivity public class MenusPresenter {

  private GetMenusUseCase useCase;
  private AddMenuUseCase addMenuUseCase;
  private Callback<List<Menu>> view;

  @Inject
  public MenusPresenter(GetMenusUseCase getMenusUseCase, AddMenuUseCase addMenuUseCase) {
    this.useCase = getMenusUseCase;
    this.addMenuUseCase = addMenuUseCase;
  }

  public void getMenus() {
    processMenusObs(getMenusObs());
  }

  public void addMenu(Menu menu) {
    Observable<List<Menu>> menusObs = getAddMenuObs(menu).observeOn(AndroidSchedulers.mainThread())
        .doOnNext(new Action1<Boolean>() {
          @Override
          public void call(Boolean aBoolean) {
            if (aBoolean) {
              view.onAddSuccess();
            }
          }
        })
        .flatMap(new Func1<Boolean, Observable<List<Menu>>>() {
          @Override
          public Observable<List<Menu>> call(Boolean b) {
            return getMenusObs();
          }
        });
    processMenusObs(menusObs);
  }

  @NonNull
  private Observable<List<Menu>> getMenusObs() {
    return Observable.defer(new Func0<Observable<List<Menu>>>() {
      @Override
      public Observable<List<Menu>> call() {
        Result<List<Menu>, Throwable> menus = useCase.getMenus();
        if (menus.getSuccess().isPresent()) {
          return Observable.just(menus.getSuccess().get());
        } else if (menus.getFailure().isPresent()) {
          return Observable.error(menus.getFailure().get());
        }
        return Observable.empty();
      }
    });
  }

  @NonNull
  private Observable<Boolean> getAddMenuObs(final Menu menu) {
    return Observable.defer(new Func0<Observable<Boolean>>() {
      @Override
      public Observable<Boolean> call() {
        Result<Boolean, Throwable> result = addMenuUseCase.addMenu(menu);
        if (result.getSuccess().isPresent()) {
          return Observable.just(result.getSuccess().get());
        } else if (result.getFailure().isPresent()) {
          return Observable.error(result.getFailure().get());
        }
        return Observable.empty();
      }
    });
  }

  private void processMenusObs(Observable<List<Menu>> menusObs) {
    menusObs.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<List<Menu>>() {
          @Override
          public void call(List<Menu> menus) {
            if (menus != null && !menus.isEmpty()) {
              view.onSuccess(menus);
            } else {
              view.onEmpty();
            }
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            view.onError();
          }
        }, new Action0() {
          @Override
          public void call() {
            view.onLoaded();
          }
        });
  }

  public void setView(Callback<List<Menu>> view) {
    this.view = view;
  }

  public interface Callback<T> {
    void onSuccess(T t);

    void onEmpty();

    void onLoaded();

    void onError();

    void onAddSuccess();
  }
}
