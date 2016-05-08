package com.alorma.intendencia.presenter;

import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.domain.usecase.GenericUseCase;
import com.alorma.intendencia.injector.PerActivity;
import java.util.List;
import javax.inject.Inject;

@PerActivity
public class MenusPresenter {

  @Inject
  public MenusPresenter(GenericUseCase<Void, List<Menu>> useCase) {

  }
}
