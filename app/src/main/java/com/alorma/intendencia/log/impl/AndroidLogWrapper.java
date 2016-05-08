package com.alorma.intendencia.log.impl;

import android.util.Log;
import com.alorma.intendencia.BuildConfig;
import com.alorma.intendencia.log.LogWrapper;

public class AndroidLogWrapper implements LogWrapper {
  @Override
  public void i(String tag, String msg) {
    if (BuildConfig.DEBUG) {
      Log.i(tag, msg);
    }
  }
}
