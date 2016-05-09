package com.alorma.intendencia.injector.component;

import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.injector.module.ApplicationModule;
import com.alorma.intendencia.log.LogWrapper;

import com.alorma.intendencia.ui.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  MenusRepository getMenusRepository();

  LogWrapper getLogWrapper();
}
