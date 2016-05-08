package com.alorma.intendencia.presenter;

import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.data.usecase.GetMenusUseCase;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.injector.PerActivity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

@PerActivity public class MenusPresenter {

  private GetMenusUseCase useCase;
  private Callback<List<Menu>> view;

  @Inject
  public MenusPresenter(GetMenusUseCase useCase) {
    this.useCase = useCase;
  }

  public void getMenus() {
    Observable.defer(new Func0<Observable<List<Menu>>>() {
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
    })
        .subscribeOn(Schedulers.newThread())
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
  }
}
