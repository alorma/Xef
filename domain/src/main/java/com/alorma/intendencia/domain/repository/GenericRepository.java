package com.alorma.intendencia.domain.repository;

import com.alorma.intendencia.domain.Result;
import com.alorma.intendencia.domain.datasource.CacheDataSource;
import com.sloydev.gallego.Optional;

public class GenericRepository<Request, Data> {

  CacheDataSource<Request, Data> cache;

  public GenericRepository(CacheDataSource<Request, Data> cache) {
    this.cache = cache;
  }

  public Result<Data, Throwable> execute(final Request request) {
    if (cache == null) {
      return new Result<>(Optional.absent(),
          Optional.of(new NullPointerException("Cache datasource cannot be null")));
    }
    return cache.getData(request);
  }
}
