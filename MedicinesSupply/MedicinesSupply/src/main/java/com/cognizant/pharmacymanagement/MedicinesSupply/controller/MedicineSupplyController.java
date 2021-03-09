package com.cognizant.pharmacymanagement.MedicinesSupply.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;


@RestController
public class MedicineSupplyController {
	
	@Autowired
	PharmacyMedicineSupplyService service;
	
	@Autowired
	private StockFeignClient stockFeignClient;
	
	
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public String showSupplyHomePage(){
		return "viewDemand";
	}


	@GetMapping(value="/SupplyAvailed")
	public ResponseEntity<?> showList(@RequestParam String name, @RequestParam int demand){
		int stock = stockFeignClient.getStockCountForMedicine(name);
		service.stockDivide(demand,name,stock);
		//model.put("pharmacyList", service.retrievePharmacies());
		//return new ModelAndView ("SupplyAvailed");
		return new ResponseEntity<>(service.retrievePharmacies(), HttpStatus.OK);	
	}
	
	
	
}
	
	