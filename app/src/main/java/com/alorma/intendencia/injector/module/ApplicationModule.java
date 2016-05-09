package com.alorma.intendencia.injector.module;

import com.alorma.intendencia.data.datasource.MenusDataSourceImpl;
import com.alorma.intendencia.data.repository.MenusRepositoryImpl;
import com.alorma.intendencia.domain.datasource.MenusDataSource;
import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.log.LogWrapper;
import com.alorma.intendencia.log.impl.AndroidLogWrapper;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
  MenusDataSource providesMenusCache() {
    return new MenusDataSourceImpl();
  }

  @Provides
  @Singleton
  MenusRepository providesMenusRepository(MenusDataSource cache) {
    return new MenusRepositoryImpl(cache);
  }
}
