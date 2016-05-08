package com.alorma.intendencia.injector.module;

import android.app.Activity;
import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.data.usecase.GetMenusUseCase;
import com.alorma.intendencia.domain.repository.GenericRepository;
import com.alorma.intendencia.domain.usecase.GenericUseCase;
import com.alorma.intendencia.injector.PerActivity;
import dagger.Module;
import dagger.Provides;
import java.util.List;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module public class ActivityModule {
  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  /**
   * Expose the activity to dependents in the graph.
   */
  @Provides
  @PerActivity
  Activity provideActivity() {
    return this.activity;
  }

  @Provides
  @PerActivity
  GenericUseCase<Void, List<Menu>> provideGetMenusUseCase(
      GenericRepository<Void, List<Menu>> repository) {
    return new GetMenusUseCase(repository);
  }
}