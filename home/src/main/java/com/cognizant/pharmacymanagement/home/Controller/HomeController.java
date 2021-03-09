package com.cognizant.pharmacymanagement.home.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	@RequestMapping(value ="/Home", method = RequestMethod.GET)
	public ModelAndView showhome() {
		return new ModelAndView("Home");
	}
}
