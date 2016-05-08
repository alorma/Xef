package com.alorma.intendencia.injector.module;

import com.alorma.intendencia.data.usecase.AddMenuUseCaseImpl;
import com.alorma.intendencia.data.usecase.GetMenusUseCase;
import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.domain.usecase.AddMenuUseCase;
import com.alorma.intendencia.injector.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module public class MenusModule {

  @Provides
  @PerActivity
  GetMenusUseCase provideGetMenusUseCase(MenusRepository repository) {
    return new GetMenusUseCase(repository);
  }

  @Provides
  @PerActivity
  AddMenuUseCase provideAddMenusUseCase(MenusRepository repository) {
    return new AddMenuUseCaseImpl(repository);
  }
}
