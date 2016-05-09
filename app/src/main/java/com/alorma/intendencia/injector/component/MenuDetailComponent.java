package com.alorma.intendencia.injector.component;

import com.alorma.intendencia.injector.PerActivity;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenuDetailModule;
import com.alorma.intendencia.ui.activity.MenuDetailActivity;
import dagger.Component;

@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, MenuDetailModule.class
})
public interface MenuDetailComponent {

  void inject(MenuDetailActivity menuDetailActivity);
}
