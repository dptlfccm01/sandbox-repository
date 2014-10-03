package com.springprojecttest.app.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springprojecttest.app.web.model.Login;
import com.springprojecttest.db.controller.PollFileController;
import com.springprojecttest.db.controller.UserFileController;
import com.springprojecttest.db.domain.Poll;
import com.springprojecttest.properties.PropertyManager;

@Controller
public class LoginController {

	@RequestMapping(value="/login.html", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(){
		ModelAndView model = new ModelAndView("LoginPage");
		return model;
	}

	
	@RequestMapping(value="/loginSuccess.html", method=RequestMethod.POST)
	public ModelAndView viewSuccessPage(@ModelAttribute("login") Login login) throws IOException{
		ModelAndView model = new ModelAndView("LoginSuccess");
		PollFileController pollFileController = new PollFileController(PropertyManager.getInstance().getPollDBPath());
		pollFileController.readFile();
		List<Poll> pollList = pollFileController.getPolls();
		model.addObject("pollList", pollList);
		return model;
	}
	
}
