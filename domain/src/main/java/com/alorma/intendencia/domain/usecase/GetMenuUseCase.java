package com.alorma.intendencia.domain.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;

public interface GetMenuUseCase {
    Result<Menu, Throwable> getMenu(String id);
}
