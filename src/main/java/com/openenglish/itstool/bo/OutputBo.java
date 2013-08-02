package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.entity.Output;
import com.openenglish.itstool.exception.DataAccessException;

public interface OutputBo extends Bo {
	
	public void save(Output object) throws DataAccessException;

	public Output get(Integer id) throws DataAccessException;

	public List<Output> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
