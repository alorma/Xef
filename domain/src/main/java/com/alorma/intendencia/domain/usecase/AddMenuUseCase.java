package com.alorma.intendencia.domain.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;

public interface AddMenuUseCase {
  Result<Boolean, Throwable> addMenu(Menu menu);
}
