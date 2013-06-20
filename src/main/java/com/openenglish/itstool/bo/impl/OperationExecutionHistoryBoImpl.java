package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.OperationExecutionHistory;
import com.openenglish.itstool.bo.OperationExecutionHistoryBo;
import com.openenglish.itstool.dao.OperationExecutionHistoryDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("operationExecutionHistoryBo")
public class OperationExecutionHistoryBoImpl implements OperationExecutionHistoryBo {
	
	@Autowired
	private OperationExecutionHistoryDao dao;

	@Override
	public void save(OperationExecutionHistory object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public OperationExecutionHistory get(Integer id) throws DataAccessException {
		return (OperationExecutionHistory) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OperationExecutionHistory> getAll() throws DataAccessException {
		return (List<OperationExecutionHistory>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
