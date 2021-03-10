package com.cognizant.pharmacymanagement.home.Controller;

import java.util.List;

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
import com.cognizant.pharmacymanagement.home.Model.PharmacyMedicineSupply;

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
		List<PharmacyMedicineSupply> list=medicineSupplyFeign.showList(name, demand);
		if(demand<5) {
			model.put("errorMessage", "Invalid Input!");
			return new ModelAndView ("viewDemand");
		}
		if(list.isEmpty()) {
			model.put("errorMessage", "Stock not available!");
			return new ModelAndView ("viewDemand");
		}
		model.put("pharmacyList", list);
		return new ModelAndView ("SupplyAvailed");
	}
}
