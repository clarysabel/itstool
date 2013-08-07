package com.openenglish.itstool.modules.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openenglish.itstool.mvc.BaseController;

@Controller
public class LoginController extends BaseController{
 
	@RequestMapping(value="/secure/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "secure/login";
	}
	
	@RequestMapping(value="/secure/error", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "secure/login";
	}
	
	@RequestMapping(value="/secure/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "home";
	}
	
}