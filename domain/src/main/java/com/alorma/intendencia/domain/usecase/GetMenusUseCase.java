package com.alorma.intendencia.domain.usecase;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;

import java.util.List;

public interface GetMenusUseCase {
    Result<List<Menu>, Throwable> getMenus();
}
