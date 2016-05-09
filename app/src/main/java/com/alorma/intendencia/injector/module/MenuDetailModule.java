package com.alorma.intendencia.injector.module;

import com.alorma.intendencia.data.usecase.GetMenuUseCaseImpl;
import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.domain.usecase.GetMenuUseCase;
import com.alorma.intendencia.injector.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class MenuDetailModule {

  @Provides
  @PerActivity
  GetMenuUseCase provideGetMenusUseCase(MenusRepository repository) {
    return new GetMenuUseCaseImpl(repository);
  }
}
