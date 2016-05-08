package com.alorma.intendencia.injector.module;

import com.alorma.intendencia.log.LogWrapper;
import com.alorma.intendencia.log.impl.AndroidLogWrapper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

  public ApplicationModule() {

  }

  @Provides
  @Singleton
  LogWrapper providesLogWrapper() {
    return new AndroidLogWrapper();
  }
}
