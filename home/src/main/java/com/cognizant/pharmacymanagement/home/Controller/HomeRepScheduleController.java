package com.cognizant.pharmacymanagement.home.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.home.FeignClient.RepScheduleFeignClient;

//import com.cognizant.pharmacymanagement.home.FeignClient.RepScheduleFeignClient;

@RestController
public class HomeRepScheduleController {
	
	@Autowired
	private RepScheduleFeignClient repScheduleClient;
	
	@RequestMapping(value ="/viewSchedule", method = RequestMethod.GET)
	public ModelAndView showRepSch() {
		return new ModelAndView(repScheduleClient.showdate());
	}
	
	@RequestMapping(value ="/RepSchedule", method = RequestMethod.GET)
	public ModelAndView showRepSch(@RequestParam String startdate,ModelMap model) {
		model.put("details",repScheduleClient.showschedule(startdate));
		return new ModelAndView("returnSchedule");
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
