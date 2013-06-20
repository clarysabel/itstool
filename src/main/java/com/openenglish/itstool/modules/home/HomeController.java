package com.openenglish.itstool.modules.home;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openenglish.itstool.mvc.BaseController;

@Controller
public class HomeController extends BaseController {

	private static Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView redirectHome() {
		ModelAndView model = new ModelAndView(new RedirectView("/app/"));

		if (logger.isDebugEnabled())
			logger.debug(model);

		return model;
	}

	@RequestMapping(value = "app/", method = RequestMethod.GET)
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView("home");
		
		if (logger.isDebugEnabled())
			logger.debug(model);

		return model;
	}

}
