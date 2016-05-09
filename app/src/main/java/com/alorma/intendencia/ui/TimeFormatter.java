package com.alorma.intendencia.ui;

public interface TimeFormatter {
  String relative(long milis);
  String absolute(long milis);
}