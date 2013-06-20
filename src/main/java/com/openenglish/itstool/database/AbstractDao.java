package com.openenglish.itstool.database;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.openenglish.itstool.common.dao.Dao;
import com.openenglish.itstool.exception.DataAccessException;

public abstract class AbstractDao implements Dao {

	private static Logger logger = Logger.getLogger(AbstractDao.class);

	private Class<?> clazz;
	
	@Autowired
	private HibernateManager hibernateManager;

	public HibernateManager getHibernateManager() {
		return hibernateManager;
	}

	public void setHibernateManager(HibernateManager hibernateManager) {
		this.hibernateManager = hibernateManager;
	}
	
	public AbstractDao(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(Object object) throws DataAccessException {
		try {
			getHibernateManager().saveOrUpdate(object);
		} catch (Exception e) {
			String message = "Error saving "+clazz.getName()+" <" + object != null ? object
					.toString() : "null" + ">";
			logger.error(message, e);
			throw new DataAccessException(message, e);
		}

	}

	@Override
	public Object get(Integer id) throws DataAccessException {
		try {
			return (Object) getHibernateManager().getById(
					clazz, id);
		} catch (Exception e) {
			String message = "Error getting "+clazz.getName()+" <"
					+ (id != null ? id : "null") + ">";
			logger.error(message, e);
			throw new DataAccessException(message, e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll() throws DataAccessException {
		try {

			List<Object> list = null;
			Criteria crit = getHibernateManager().getHibernateSession()
					.createCriteria(clazz);
			list = (List<Object>) crit.list();

			return list;

		} catch (Exception e) {
			String message = "Error getting all "+clazz.getName();
			logger.error(message, e);
			throw new DataAccessException(message, e);
		}
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		try {
			getHibernateManager().delete(clazz, id);
		} catch (Exception e) {
			String message = "Error deleting "+clazz.getName()+" <"
					+ (id != null ? id
							: "null") + ">";
			logger.error(message, e);
			throw new DataAccessException(message, e);
		}

	}

}
