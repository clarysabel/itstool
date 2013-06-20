package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Role;
import com.openenglish.itstool.dao.RoleDao;
import com.openenglish.itstool.database.AbstractDao;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}
	
}
