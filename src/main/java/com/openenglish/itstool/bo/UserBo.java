package com.openenglish.itstool.bo;

import java.util.List;

import com.openenglish.itstool.bean.User;
import com.openenglish.itstool.common.bo.Bo;
import com.openenglish.itstool.exception.DataAccessException;

public interface UserBo extends Bo {
	
	public void save(User object) throws DataAccessException;

	public User get(Integer id) throws DataAccessException;

	public List<User> getAll() throws DataAccessException;

	public void delete(Integer id) throws DataAccessException;
	
	public User findByEmail(String email) throws DataAccessException;

}
