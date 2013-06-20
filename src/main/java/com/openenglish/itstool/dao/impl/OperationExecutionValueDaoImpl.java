package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.dao.OperationExecutionValueDao;
import com.openenglish.itstool.database.AbstractDao;

@Repository("operationExecutionValueDao")
public class OperationExecutionValueDaoImpl extends AbstractDao implements OperationExecutionValueDao {

	public OperationExecutionValueDaoImpl() {
		super(OperationExecutionValueDao.class);
	}

}
