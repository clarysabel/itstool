package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Operation;
import com.openenglish.itstool.bo.OperationBo;
import com.openenglish.itstool.dao.OperationDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("operationBo")
public class OperationBoImpl implements OperationBo {
	
	@Autowired
	private OperationDao dao;

	@Override
	public void save(Operation object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public Operation get(Integer id) throws DataAccessException {
		return (Operation) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getAll() throws DataAccessException {
		return (List<Operation>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
