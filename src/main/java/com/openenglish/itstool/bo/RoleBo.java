package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.bean.Role;
import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.exception.DataAccessException;

public interface RoleBo extends Bo {
	
	public void save(Role object) throws DataAccessException;

	public Role get(Integer id) throws DataAccessException;

	public List<Role> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;

}
