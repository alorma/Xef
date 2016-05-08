package com.alorma.intendencia.data.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.repository.MenusRepository;
import com.alorma.intendencia.domain.usecase.AddMenuUseCase;

public class AddMenuUseCaseImpl implements AddMenuUseCase {
  private MenusRepository repository;

  public AddMenuUseCaseImpl(MenusRepository repository) {

    this.repository = repository;
  }

  @Override
  public Result<Boolean, Throwable> addMenu(Menu menu) {
    return repository.addMenu(menu);
  }
}
