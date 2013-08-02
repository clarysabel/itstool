package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.dao.OperationDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.entity.Operation;

@Repository("operationDao")
public class OperationDaoImpl extends AbstractDao implements OperationDao {

	public OperationDaoImpl() {
		super(Operation.class);
	}

}
