package com.alorma.intendencia.injector.component;

import com.alorma.intendencia.injector.PerActivity;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenusModule;
import com.alorma.intendencia.ui.MainActivity;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, MenusModule.class
})
public interface MenusComponent extends ActivityComponent {

  void inject(MainActivity mainActivity);
}
