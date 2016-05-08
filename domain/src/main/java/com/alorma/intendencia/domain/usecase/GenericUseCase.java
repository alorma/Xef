package com.alorma.intendencia.domain.usecase;

import com.alorma.intendencia.domain.repository.GenericRepository;

public abstract class GenericUseCase<Request, Data> {

  GenericRepository<Request, Data> repository;

  public GenericUseCase(GenericRepository<Request, Data> repository) {
    if (repository == null) {
      throw new NullPointerException("Repository cannot be null");
    }
    this.repository = repository;
  }

  public GenericRepository<Request, Data> getRepository() {
    return repository;
  }
}
