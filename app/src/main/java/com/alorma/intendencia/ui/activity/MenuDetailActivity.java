package com.alorma.intendencia.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.alorma.intendencia.R;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.injector.component.DaggerMenuDetailComponent;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenuDetailModule;
import com.alorma.intendencia.presenter.MenuDetailPresenter;
import javax.inject.Inject;
import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder public class MenuDetailActivity extends BaseActivity {

  @Inject MenuDetailPresenter presenter;

  @Extra String menuExtraId;

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.viewPager) ViewPager pager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_detail);

    MenuDetailActivityIntentBuilder.inject(getIntent(), this);

    ButterKnife.bind(this);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
      if (getSupportActionBar() != null) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      }
    }
  }

  @Override
  protected void initializeInjection(ApplicationComponent component) {
    component.inject(this);

    // PerActivity injector initialization
    DaggerMenuDetailComponent.builder()
        .applicationComponent(component) // Main component must be set
        .activityModule(new ActivityModule(this)) // Initialize dependencies
        .menuDetailModule(new MenuDetailModule())
        .build()
        .inject(this); // Make PerActivity module
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.getMenu(menuExtraId);
  }
}
