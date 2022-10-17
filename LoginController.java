package com.gl.caseStudy4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	/*@GetMapping(value="/welcome")
	public ModelAndView showWelcomePage() {
		return new ModelAndView("welcomePage");
	}*/
	@GetMapping(value="/loginpage")
	public ModelAndView showLoginPage() {
		return new ModelAndView("loginPage");
	}
	@GetMapping(value="/loginerror")
	public ModelAndView showErrorPage() {
		return new ModelAndView("errorPage");
	}
	

}
