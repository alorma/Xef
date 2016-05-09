package com.alorma.intendencia.data.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.domain.usecase.GetMenuUseCase;

public class GetMenuUseCaseImpl implements GetMenuUseCase {
  private MenusRepository repository;

  public GetMenuUseCaseImpl(MenusRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<Menu, Throwable> getMenu(String id) {
    return repository.getMenu(id);
  }
}
