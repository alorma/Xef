package com.alorma.intendencia.injector.module;

import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.data.usecase.GetMenusUseCase;
import com.alorma.intendencia.domain.repository.GenericRepository;
import com.alorma.intendencia.injector.PerActivity;
import dagger.Module;
import dagger.Provides;
import java.util.List;

@Module public class MenusModule {

  @Provides
  @PerActivity
  GetMenusUseCase provideGetMenusUseCase(
      GenericRepository<Void, List<Menu>> repository) {
    return new GetMenusUseCase(repository);
  }
}
