package com.alorma.intendencia.data.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.repository.MenusRepository;
import java.util.List;

public class GetMenusUseCaseImpl implements com.alorma.intendencia.domain.usecase.GetMenusUseCase {
  private MenusRepository repository;

  public GetMenusUseCaseImpl(MenusRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<Menu>, Throwable> getMenus() {
    return repository.getMenus();
  }
}
