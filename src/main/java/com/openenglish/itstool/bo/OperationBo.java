package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.entity.Operation;
import com.openenglish.itstool.exception.DataAccessException;

public interface OperationBo extends Bo {
	
	public void save(Operation object) throws DataAccessException;

	public Operation get(Integer id) throws DataAccessException;

	public List<Operation> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
