package icu.xiii.springdatajpa.service;

import java.util.List;

public interface BaseService<T,S> {
    List<T> getAll();
    T getById(Long id);
    T create(S request);
    T updateById(Long id, S request);
    boolean deleteById(Long id);
}
