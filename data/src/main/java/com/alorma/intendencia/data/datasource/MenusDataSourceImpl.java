package com.alorma.intendencia.data.datasource;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.MenusDataSource;
import com.sloydev.gallego.Optional;
import java.util.ArrayList;
import java.util.List;

public class MenusDataSourceImpl implements MenusDataSource {

  private List<Menu> menus = new ArrayList<>();

  public MenusDataSourceImpl() {

  }

  @Override
  public Result<List<Menu>, Throwable> getMenus() {
    Optional<List<Menu>> success = Optional.<List<Menu>>of(menus);
    return new Result<>(success, Optional.<Throwable>absent());
  }

  @Override
  public Result<Boolean, Throwable> addMenu(Menu menu) {
    return new Result<>(Optional.of(menus.add(menu)), Optional.<Throwable>absent());
  }
}
