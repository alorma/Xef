package com.alorma.intendencia.data.datasource;

import android.content.Context;
import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.CacheDataSource;
import com.sloydev.gallego.Optional;
import java.util.ArrayList;
import java.util.List;

public class MenusDataSource implements CacheDataSource<Void, List<Menu>> {
  public MenusDataSource(Context context) {

  }

  @Override
  public void saveData(Void aVoid, List<Menu> menus) {

  }

  @Override
  public Result<List<Menu>, Throwable> getData(Void aVoid) {
    List<Menu> menus = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      menus.add(new Menu());
    }
    Optional<List<Menu>> success = Optional.of(menus);
    return new Result<>(success, Optional.<Throwable>absent());
  }
}
