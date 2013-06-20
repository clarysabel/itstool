package com.openenglish.itstool.mvc;

import org.springframework.context.ApplicationContext;

import com.openenglish.itstool.context.ContextManager;

public abstract class BaseController {
	
	protected ApplicationContext getApplicationContext () {
		return ContextManager.getApplicationContext();
	}
	
	protected Object getBean (String beanName) {
		return getApplicationContext().getBean(beanName);
	}
	
}
