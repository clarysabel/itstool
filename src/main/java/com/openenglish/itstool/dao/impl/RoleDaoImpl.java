package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.dao.RoleDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}
	
}
