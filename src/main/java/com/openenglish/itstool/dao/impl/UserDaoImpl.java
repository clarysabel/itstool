package com.openenglish.itstool.dao.impl;

import java.util.HashMap;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.openenglish.itstool.dao.UserDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.entity.User;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {
	
	private static final String EMAIL_FIELD = "email";
	private static final String USERNAME_FIELD = "username";
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional (readOnly = true)
	public User findByEmail(String email) throws DataAccessException {
		if (email == null) {
			logger.error("Searching for null nickname");
			return null;
		} else {
			email = email.toLowerCase();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put(EMAIL_FIELD, email);

		List<User> result = (List<User>) (List<?>) getHibernateManager()
				.getByCriteria(User.class, EMAIL_FIELD, email);

    	if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public User findByUsername(String username) throws DataAccessException {
		if (username == null || username.equals("")) {
			logger.error("Searching for null or empty username");
			return null;
		} 
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put(USERNAME_FIELD, username);

		List<User> result = (List<User>) (List<?>) getHibernateManager()
				.getByCriteria(User.class, USERNAME_FIELD, username);

		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

}
