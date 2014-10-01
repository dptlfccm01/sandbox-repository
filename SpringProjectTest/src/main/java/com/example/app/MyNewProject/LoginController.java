package com.example.app.MyNewProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/login.html", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(){
		ModelAndView model = new ModelAndView("LoginPage");
		return model;
	}

	
	@RequestMapping(value="/loginSuccess.html", method=RequestMethod.POST)
	public ModelAndView viewSuccessPage(){
		ModelAndView model = new ModelAndView("LoginSuccess");
		return model;
	}
	
}
