package com.alorma.intendencia.data.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.repository.MenusRepository;
import java.util.List;

public class GetMenusUseCase {
  private MenusRepository repository;

  public GetMenusUseCase(MenusRepository repository) {
    this.repository = repository;
  }

  public Result<List<Menu>, Throwable> getMenus() {
    return repository.getMenus();
  }
}
