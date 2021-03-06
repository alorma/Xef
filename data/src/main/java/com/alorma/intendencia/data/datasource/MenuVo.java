package com.alorma.intendencia.data.datasource;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MenuVo extends RealmObject {

  @PrimaryKey
  private String key;

  private String name;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
