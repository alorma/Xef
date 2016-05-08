package com.alorma.intendencia.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.alorma.intendencia.IntendenciaApplication;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import com.alorma.intendencia.log.LogWrapper;
import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

  @Inject protected LogWrapper logWrapper;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ApplicationComponent component = ((IntendenciaApplication) getApplication()).getComponent();
    initializeInjection(component);
  }

  protected abstract void initializeInjection(ApplicationComponent component);
}
