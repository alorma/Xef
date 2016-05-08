package com.alorma.intendencia.ui;

import android.os.Bundle;
import com.alorma.intendencia.R;
import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.injector.component.DaggerMenusComponent;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenusModule;
import com.alorma.intendencia.presenter.MenusPresenter;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MenusPresenter.Callback<List<Menu>> {

  @Inject MenusPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    logWrapper.i("IntendenciaApp", "Hello World");
    logWrapper.i("IntendenciaApp", "Presenter: " + (presenter != null));

    initializePresenter();
  }

  @Override
  protected void initializeInjection(ApplicationComponent component) {
    component.inject(this);

    // PerActivity injector initialization
    DaggerMenusComponent.builder().applicationComponent(component) // Main component must be set
        .activityModule(new ActivityModule(this)) // Initialize dependencies
        .menusModule(new MenusModule()).build().inject(this); // Make PerActivity module
  }

  private void initializePresenter() {
    presenter.setView(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.getMenus();
  }

  @Override
  public void onSuccess(List<Menu> menus) {

  }

  @Override
  public void onEmpty() {

  }

  @Override
  public void onLoaded() {

  }

  @Override
  public void onError() {

  }
}
