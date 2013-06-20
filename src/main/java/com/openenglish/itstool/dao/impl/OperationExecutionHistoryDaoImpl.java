package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.OperationExecutionHistory;
import com.openenglish.itstool.dao.OperationExecutionHistoryDao;
import com.openenglish.itstool.database.AbstractDao;

@Repository("operationExecutionHistoryDao")
public class OperationExecutionHistoryDaoImpl extends AbstractDao implements OperationExecutionHistoryDao {

	public OperationExecutionHistoryDaoImpl() {
		super(OperationExecutionHistory.class);
	}

}
