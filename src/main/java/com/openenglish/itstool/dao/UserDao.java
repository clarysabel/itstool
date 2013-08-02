package com.openenglish.itstool.dao;

import com.openenglish.itstool.common.dao.Dao;
import com.openenglish.itstool.entity.User;
import com.openenglish.itstool.exception.DataAccessException;

public interface UserDao extends Dao {

	public User findByEmail(String email) throws DataAccessException;

}
