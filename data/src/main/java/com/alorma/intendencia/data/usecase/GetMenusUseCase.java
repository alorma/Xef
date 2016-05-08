package com.alorma.intendencia.data.usecase;

import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.domain.repository.GenericRepository;
import com.alorma.intendencia.domain.usecase.GenericUseCase;
import java.util.List;

public class GetMenusUseCase extends GenericUseCase<Void, List<Menu>> {
  public GetMenusUseCase(GenericRepository<Void, List<Menu>> repository) {
    super(repository);
  }

  public void getMenus() {

  }
}
