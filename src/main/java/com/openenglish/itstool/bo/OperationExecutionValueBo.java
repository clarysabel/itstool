package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.bean.OperationExecutionValue;
import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.exception.DataAccessException;

public interface OperationExecutionValueBo extends Bo {
	
	public void save(OperationExecutionValue object) throws DataAccessException;

	public OperationExecutionValue get(Integer id) throws DataAccessException;

	public List<OperationExecutionValue> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
