package com.alorma.intendencia.ui;

import android.os.Bundle;
import com.alorma.intendencia.R;
import com.alorma.intendencia.injector.component.ApplicationComponent;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    logWrapper.i("IntendenciaApp", "Hello World");
  }

  @Override
  protected void initializeInjection(ApplicationComponent component) {
    component.inject(this);
  }
}
