package com.openenglish.itstool.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.User;
import com.openenglish.itstool.dao.UserDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	private static final String EMAIL_FIELD = "email";
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@SuppressWarnings("unchecked")
	public User findByEmail(String email) throws DataAccessException {
		if (email == null) {
			logger.error("Searching for null nickname");
			return null;
		} else
			email = email.toLowerCase();
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

}
