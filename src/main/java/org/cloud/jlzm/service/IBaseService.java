package org.cloud.jlzm.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T> {

	Integer getCount(T entity);

    Optional<T> getById(Integer id);

    List<T> getAll();

    List<T> getAll(int pageNum, int pageSize);

    int save(T entity);

    int deleteById(Integer id);
}

