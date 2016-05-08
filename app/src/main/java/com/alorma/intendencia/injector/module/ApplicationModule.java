package com.alorma.intendencia.injector.module;

import android.content.Context;
import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.data.datasource.MenusDataSource;
import com.alorma.intendencia.domain.datasource.CacheDataSource;
import com.alorma.intendencia.domain.repository.GenericRepository;
import com.alorma.intendencia.log.LogWrapper;
import com.alorma.intendencia.log.impl.AndroidLogWrapper;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;

@Module public class ApplicationModule {

  private Context application;

  public ApplicationModule(Context application) {
    this.application = application;
  }

  @Provides
  @Singleton
  LogWrapper providesLogWrapper() {
    return new AndroidLogWrapper();
  }

  @Provides
  @Singleton
  Context providesApplicationContext() {
    return this.application;
  }

  @Provides
  @Singleton
  CacheDataSource<Void, List<Menu>> providesMenusCache(Context context) {
    return new MenusDataSource(context);
  }

  @Provides
  @Singleton
  GenericRepository<Void, List<Menu>> providesMenusRepository(
      CacheDataSource<Void, List<Menu>> cache) {
    return new GenericRepository<>(cache);
  }
}
