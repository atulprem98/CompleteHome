package com.cognizant.pharmacymanagement.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.home.FeignClient.MedicineSupplyFeignClient;

@RestController
public class HomeMedicineSupplyController {
	
	@Autowired
	private MedicineSupplyFeignClient medicineSupplyFeign;
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyPage(){
		return new ModelAndView(medicineSupplyFeign.showSupplyHomePage());
	}
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(@RequestParam String name, @RequestParam int demand,ModelMap model){
		model.put("pharmacyList", medicineSupplyFeign.showList(name, demand));
		return new ModelAndView ("SupplyAvailed");
	}
}
