package com.alorma.intendencia.domain.datasource;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import java.util.List;

public interface MenusDataSource {
  Result<List<Menu>, Throwable> getMenus();

  Result<Boolean, Throwable> addMenu(Menu menu);
}
