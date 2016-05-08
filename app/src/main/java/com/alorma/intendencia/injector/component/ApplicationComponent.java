package com.alorma.intendencia.injector.component;

import com.alorma.intendencia.injector.module.ApplicationModule;
import com.alorma.intendencia.ui.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(MainActivity mainActivity);
}
