package com.cognizant.pharmacymanagement.home.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.home.Model.RepSchedule;

@FeignClient(url="http://localhost:8082", name="RepresentativeSchedule")
public interface RepScheduleFeignClient {
	
	@GetMapping("/viewSchedule")
	public String showdate();
	
	@GetMapping("/RepSchedule")
	public List<RepSchedule> showschedule(@RequestParam String startdate);
}