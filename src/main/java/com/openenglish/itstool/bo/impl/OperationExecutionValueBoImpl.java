package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.OperationExecutionValue;
import com.openenglish.itstool.bo.OperationExecutionValueBo;
import com.openenglish.itstool.dao.OperationExecutionValueDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("operationExecutionValueBo")
public class OperationExecutionValueBoImpl implements OperationExecutionValueBo {
	
	@Autowired
	private OperationExecutionValueDao dao;

	@Override
	public void save(OperationExecutionValue object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public OperationExecutionValue get(Integer id) throws DataAccessException {
		return (OperationExecutionValue) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OperationExecutionValue> getAll() throws DataAccessException {
		return (List<OperationExecutionValue>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
