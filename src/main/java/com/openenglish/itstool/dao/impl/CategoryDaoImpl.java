package com.openenglish.itstool.dao.impl;

import org.springframework.stereotype.Repository;

import com.openenglish.itstool.dao.CategoryDao;
import com.openenglish.itstool.database.AbstractDao;
import com.openenglish.itstool.entity.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{

	public CategoryDaoImpl() {
		super(Category.class);
	}

}
