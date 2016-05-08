package com.alorma.intendencia.data.repository;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.MenusDataSource;
import com.alorma.intendencia.domain.repository.MenusRepository;
import java.util.List;

public class MenusRepositoryImpl implements MenusRepository {
  private MenusDataSource cache;

  public MenusRepositoryImpl(MenusDataSource cache) {

    this.cache = cache;
  }

  @Override
  public Result<List<Menu>, Throwable> getMenus() {
    return cache.getMenus();
  }

  @Override
  public Result<Boolean, Throwable> addMenu(Menu menu) {
    return cache.addMenu(menu);
  }
}
