package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Output;
import com.openenglish.itstool.dao.OutputDao;
import com.openenglish.itstool.database.AbstractDao;

@Repository("outputDao")
public class OutputDaoImpl extends AbstractDao implements OutputDao {

	public OutputDaoImpl() {
		super(Output.class);
	}

}
