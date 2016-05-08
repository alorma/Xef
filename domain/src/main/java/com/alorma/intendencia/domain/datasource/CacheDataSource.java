package com.alorma.intendencia.domain.datasource;

import com.alorma.intendencia.domain.Result;

public interface CacheDataSource<Request, Data> {

  void saveData(Request request, Data data);

  Result<Data, Throwable> getData(Request request);
}
