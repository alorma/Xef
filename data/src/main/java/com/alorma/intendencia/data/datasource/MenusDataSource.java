package com.alorma.intendencia.data.datasource;

import android.content.Context;
import com.alorma.intendencia.data.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.CacheDataSource;
import java.util.List;

public class MenusDataSource implements CacheDataSource<Void,List<Menu>> {
  public MenusDataSource(Context context) {

  }

  @Override
  public void saveData(Void aVoid, List<Menu> menus) {

  }

  @Override
  public Result<List<Menu>, Throwable> getData(Void aVoid) {
    return null;
  }
}
