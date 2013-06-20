package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Input;
import com.openenglish.itstool.bo.InputBo;
import com.openenglish.itstool.dao.InputDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("inputBo")
public class InputBoImpl implements InputBo {
	
	@Autowired
	private InputDao dao;

	@Override
	public void save(Input object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public Input get(Integer id) throws DataAccessException {
		return (Input) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Input> getAll() throws DataAccessException {
		return (List<Input>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
