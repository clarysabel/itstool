package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bo.UserBo;
import com.openenglish.itstool.dao.UserDao;
import com.openenglish.itstool.entity.User;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("userBo")
public class UserBoImpl implements UserBo {
	
	@Autowired
	private UserDao dao;

	@Override
	public void save(User object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public User get(Integer id) throws DataAccessException {
		return (User) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() throws DataAccessException {
		return (List<User>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

	@Override
	public User findByEmail(String email) throws DataAccessException {
		return dao.findByEmail(email);
	}

}
