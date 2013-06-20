package com.openenglish.itstool.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openenglish.itstool.bean.Output;
import com.openenglish.itstool.bo.OutputBo;
import com.openenglish.itstool.dao.OutputDao;
import com.openenglish.itstool.exception.DataAccessException;

@Repository("outputBo")
public class OutputBoImpl implements OutputBo {
	
	@Autowired
	private OutputDao dao;

	@Override
	public void save(Output object) throws DataAccessException {
		dao.save(object);
	}

	@Override
	public Output get(Integer id) throws DataAccessException {
		return (Output) dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Output> getAll() throws DataAccessException {
		return (List<Output>) (List<?>) dao.getAll();
	}

	@Override
	public void delete(Integer id) throws DataAccessException {
		dao.delete(id);
	}

}
