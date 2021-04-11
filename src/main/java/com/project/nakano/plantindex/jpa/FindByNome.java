package com.project.nakano.plantindex.jpa;

public interface FindByNome<T> {
  T findByNome(String nome);
}
