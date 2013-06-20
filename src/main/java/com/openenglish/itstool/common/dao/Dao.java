package com.openenglish.itstool.common.dao;

import java.util.List;

import com.openenglish.itstool.exception.DataAccessException;

public interface Dao {

	public void save(Object object) throws DataAccessException;

	public Object get(Integer id) throws DataAccessException;

	public List<Object> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
