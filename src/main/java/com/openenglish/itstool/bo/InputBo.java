package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.bean.Input;
import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.exception.DataAccessException;

public interface InputBo extends Bo {
	
	public void save(Input object) throws DataAccessException;

	public Input get(Integer id) throws DataAccessException;

	public List<Input> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
