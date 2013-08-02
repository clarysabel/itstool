package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.dao.InputDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.entity.Input;

@Repository("inputDao")
public class InputDaoImpl extends AbstractDao implements InputDao {

	public InputDaoImpl() {
		super(Input.class);
	}

}
