package com.alorma.intendencia.presenter;

import com.alorma.intendencia.domain.usecase.GetMenuUseCase;
import com.alorma.intendencia.injector.PerActivity;
import javax.inject.Inject;

@PerActivity
public class MenuDetailPresenter {

  private GetMenuUseCase useCase;

  @Inject
  public MenuDetailPresenter(GetMenuUseCase useCase) {
    this.useCase = useCase;
  }

  public void getMenu(String id) {
    useCase.getMenu(id);
  }
}
