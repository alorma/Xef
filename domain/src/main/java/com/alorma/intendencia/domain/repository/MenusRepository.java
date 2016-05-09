package com.alorma.intendencia.domain.repository;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import java.util.List;

public interface MenusRepository {
  Result<Boolean, Throwable> clear();

  Result<Boolean, Throwable> remove(String id);

  Result<Boolean, Throwable> remove(Menu menu);

  Result<List<Menu>, Throwable> getMenus();

  Result<Menu, Throwable> getMenu(String id);

  Result<Boolean, Throwable> addMenu(Menu menu);
}
