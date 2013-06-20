package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Role;
import com.openenglish.itstool.bo.RoleBo;
import com.openenglish.itstool.dao.RoleDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("roleBo")
public class RoleBoImpl implements RoleBo {
	
	@Autowired
	private RoleDao dao;

	@Override
	public void save(Role object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public Role get(Integer id) throws DataAccessException {
		return (Role) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() throws DataAccessException {
		return (List<Role>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
