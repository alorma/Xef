package com.alorma.intendencia.injector.component;

import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.domain.repository.GenericRepository;
import com.alorma.intendencia.injector.module.ApplicationModule;
import com.alorma.intendencia.log.LogWrapper;
import com.alorma.intendencia.ui.BaseActivity;
import dagger.Component;
import java.util.List;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  GenericRepository<Void, List<Menu>> getMenusRepository();

  LogWrapper getLogWrapper();
}
