package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openenglish.itstool.bo.UserBo;
import com.openenglish.itstool.dao.UserDao;
import com.openenglish.itstool.entity.User;
import com.openenglish.itstool.exception.DataAccessException;

@Service("userBo")
public class UserBoImpl implements UserBo {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void save(User object) throws DataAccessException {
		userDao.save(object);
	}

	@Override
	public User get(Integer id) throws DataAccessException {
		return (User) userDao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() throws DataAccessException {
		return (List<User>) (List<?>) userDao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		userDao.delete(id);
	}

	@Override
	public User findByEmail(String email) throws DataAccessException {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) throws DataAccessException {
		return userDao.findByUsername(username);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
