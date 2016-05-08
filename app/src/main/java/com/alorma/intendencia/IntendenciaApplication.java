package com.alorma.intendencia;

import android.app.Application;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.injector.component.DaggerApplicationComponent;
import com.alorma.intendencia.injector.module.ApplicationModule;

public class IntendenciaApplication extends Application {
  private ApplicationComponent component;

  @Override
  public void onCreate() {
    super.onCreate();

    initializeInjector();
  }

  private void initializeInjector() {
    component =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule()).build();
  }

  public ApplicationComponent getComponent() {
    return component;
  }
}
