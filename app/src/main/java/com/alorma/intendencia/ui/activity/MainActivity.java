package com.alorma.intendencia.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.alorma.intendencia.R;
import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.injector.component.DaggerMenusComponent;
import com.alorma.intendencia.injector.module.ActivityModule;
import com.alorma.intendencia.injector.module.MenusModule;
import com.alorma.intendencia.presenter.MenusPresenter;
import com.alorma.intendencia.ui.adapter.MenusAdapter;
import com.alorma.intendencia.ui.adapter.RecyclerArrayAdapter;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;

public class MainActivity extends BaseActivity
    implements MenusPresenter.Callback<List<Menu>>, RecyclerArrayAdapter.ItemCallback<Menu> {

  @Inject MenusPresenter presenter;

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.recyclerView) RecyclerView recyclerView;
  @Bind(R.id.fab) FloatingActionButton fab;

  private MenusAdapter adapter;
  private Snackbar snackbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }


    initializeViews();
    initializePresenter();
  }

  @Override
  protected void initializeInjection(ApplicationComponent component) {
    component.inject(this);

    // PerActivity injector initialization
    DaggerMenusComponent.builder().applicationComponent(component) // Main component must be set
        .activityModule(new ActivityModule(this)) // Initialize dependencies
        .menusModule(new MenusModule()).build().inject(this); // Make PerActivity module
  }

  private void initializeViews() {
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    adapter = new MenusAdapter(getLayoutInflater());
    adapter.setCallback(this);

    recyclerView.setAdapter(adapter);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Menu menu = new Menu();
        menu.setName(UUID.randomUUID().toString());
        presenter.addMenu(menu);
      }
    });
  }

  private void initializePresenter() {
    presenter.setView(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.getMenus();
  }

  @Override
  public void onSuccess(List<Menu> menus) {
    adapter.clear();
    adapter.addAll(menus);
  }

  @Override
  public void onEmpty() {

  }

  @Override
  public void onLoaded() {

  }

  @Override
  public void onError() {

  }

  @Override
  public void onAddSuccess() {
    if (snackbar == null) {
      snackbar = Snackbar.make(recyclerView, "Menu añadido", Snackbar.LENGTH_SHORT);
    }
    if (!snackbar.isShown()) {
      snackbar.show();
    }
  }

  @Override
  public void onItemSelected(Menu item) {
    Intent intent = new MenuDetailActivityIntentBuilder(item.getId()).build(this);
    startActivity(intent);
  }
}
