package com.alorma.intendencia.ui;

import android.os.Bundle;
import com.alorma.intendencia.R;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.injector.component.DaggerMenusComponent;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenusModule;
import com.alorma.intendencia.presenter.MenusPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject MenusPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    logWrapper.i("IntendenciaApp", "Hello World");
    logWrapper.i("IntendenciaApp", "Presenter: " + (presenter != null));
  }

  @Override
  protected void initializeInjection(ApplicationComponent component) {
    component.inject(this);

    // PerActivity injector initialization
    DaggerMenusComponent.builder().applicationComponent(component) // Main component must be set
        .activityModule(new ActivityModule(this)) // Initialize dependencies
        .menusModule(new MenusModule()).build().inject(this); // Make PerActivity module
  }
}
