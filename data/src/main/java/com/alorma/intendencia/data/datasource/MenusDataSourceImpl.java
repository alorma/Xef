package com.alorma.intendencia.data.datasource;

import com.alorma.intendencia.domain.Menu;
import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.MenusDataSource;
import com.sloydev.gallego.Optional;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenusDataSourceImpl implements MenusDataSource {

  private final Realm realm;

  public MenusDataSourceImpl(RealmConfiguration realmConfiguration) {
    Realm.setDefaultConfiguration(realmConfiguration);
    realm = Realm.getDefaultInstance();
  }

  @Override
  public Result<List<Menu>, Throwable> getMenus() {
    RealmResults<MenuVo> menuVos = Realm.getDefaultInstance().allObjects(MenuVo.class);
    List<Menu> menus = new ArrayList<>();
    for (MenuVo menuVo : menuVos) {
      mapMenuVo(menuVo);
    }
    Optional<List<Menu>> success = Optional.of(menus);
    return new Result<>(success, Optional.<Throwable>absent());
  }

  private Menu mapMenuVo(MenuVo menuVo) {
    Menu menu = new Menu();
    menu.setId(menuVo.getKey());
    menu.setName(menuVo.getName());
    return menu;
  }

  private MenuVo mapMenu(Menu menu) {
    MenuVo menuVo = new MenuVo();
    menuVo.setKey(UUID.randomUUID().toString());
    menuVo.setName(menu.getName());
    return menuVo;
  }

  @Override
  public Result<Boolean, Throwable> addMenu(Menu menu) {
    MenuVo menuVo = realm.copyToRealm(mapMenu(menu));
    return new Result<>(Optional.of(menuVo.isValid()), Optional.<Throwable>absent());
  }
}
