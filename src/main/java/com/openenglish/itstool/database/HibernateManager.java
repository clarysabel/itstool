package com.openenglish.itstool.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateManager extends HibernateDaoSupport {

	public List<?> getAll (Class<?> clazz) {
		return getSession().createCriteria(clazz).list();
	}
	
	public Object getById (Class<?> clazz, Integer id) {
		return getSession().load(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getByCriteria (Class<?> clazz, String field, Object condition) {
		Criterion cr1 = Restrictions.eq(field, condition);
		Session s = getSession();
		Criteria criteria = s.createCriteria(clazz);
		criteria.add(cr1);
		return criteria.list();
	}
	
	public void saveOrUpdate (Object o) {
		Session s = getSession();
		s.saveOrUpdate(o);
		s.flush();
	}
	
	public void delete (Class<?> clazz, Integer id) {
		Session s = getSession();
		s.delete(getById(clazz, id));
		s.flush();
	}
	
	public Session getHibernateSession () {
		return getSession();
	}
	
}
