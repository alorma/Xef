package com.alorma.intendencia.domain;

import com.sloydev.gallego.Optional;

public final class Result<S, F> {

  private final Optional<S> success;
  private final Optional<F> failure;

  public Result(Optional<S> success, Optional<F> failure) {
    this.success = success;
    this.failure = failure;
  }

  public static <S, F> Result<S, F> success(S success) {
    return new Result<>(Optional.of(success), Optional.<F>absent());
  }

  public static <S, F> Result<S, F> failure(F failure) {
    return new Result<>(Optional.<S>absent(), Optional.of(failure));
  }

  public Optional<S> getSuccess() {
    return success;
  }

  public Optional<F> getFailure() {
    return failure;
  }
}