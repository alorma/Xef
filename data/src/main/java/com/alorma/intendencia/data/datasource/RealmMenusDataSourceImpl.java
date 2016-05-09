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

public class RealmMenusDataSourceImpl implements MenusDataSource {

  private RealmConfiguration realmConfiguration;

  public RealmMenusDataSourceImpl(final RealmConfiguration realmConfiguration) {
    this.realmConfiguration = realmConfiguration;
  }

  private Realm getRealmInstance() {
    return Realm.getInstance(realmConfiguration);
  }

  @Override
  public Result<List<Menu>, Throwable> getMenus() {
    final Realm realm = getRealmInstance();
    RealmResults<MenuVo> menuVos = realm.where(MenuVo.class).findAll();
    List<Menu> menus = new ArrayList<>();
    for (MenuVo menuVo : menuVos) {
      menus.add(mapMenuVo(menuVo));
    }
    realm.close();
    Optional<List<Menu>> success = Optional.of(menus);
    return new Result<>(success, Optional.<Throwable>absent());
  }

  @Override
  public Result<Boolean, Throwable> addMenu(Menu menu) {
    final Realm realm = getRealmInstance();
    final MenuVo menuVo = mapMenu(menu);
    realm.executeTransaction(new Realm.Transaction() {
      @Override
      public void execute(Realm realm) {
        realm.copyToRealmOrUpdate(menuVo);
      }
    });
    realm.close();
    return new Result<>(Optional.of(true), Optional.<Throwable>absent());
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
}
