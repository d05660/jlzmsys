package org.cloud.jlzm.base;

import java.util.List;

public interface BaseMapper<T> {

	Integer selectCount(T entity);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(T entity);

    Integer insertSelective(T entity);

    Integer updateByPrimaryKey(T entity);
}
