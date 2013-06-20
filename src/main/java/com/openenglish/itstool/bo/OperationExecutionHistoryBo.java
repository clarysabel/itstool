package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.bean.OperationExecutionHistory;
import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.exception.DataAccessException;

public interface OperationExecutionHistoryBo extends Bo {
	
	public void save(OperationExecutionHistory object) throws DataAccessException;

	public OperationExecutionHistory get(Integer id) throws DataAccessException;

	public List<OperationExecutionHistory> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
