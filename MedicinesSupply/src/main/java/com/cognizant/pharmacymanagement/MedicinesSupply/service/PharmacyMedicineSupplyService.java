package com.cognizant.pharmacymanagement.MedicinesSupply.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.*;



@Service
public class PharmacyMedicineSupplyService {
	private static int supply=0;
	private static String medName;
	PharmacyList ph;
	StockFeignClient stockFeignClient;
	private static int stock;
	
	private static List<PharmacyMedicineSupply> pharmacyList = new ArrayList<PharmacyMedicineSupply>();
    


    public List<PharmacyMedicineSupply> retrievePharmacies() {
    	
        return pharmacyList;
    }
    public void getStock(int stock) {
    	stock = stock;
    }
    public void stockDivide(int demand,String medicine, int stock) {
    	pharmacyList.clear();
    	
    	if (demand>stock) {
    		supply=0;
    	}
    	else {
    	supply=demand/5;}
    	medName = medicine;
    	pharmacyList.add(new PharmacyMedicineSupply("MedCity",medName,supply));
    	pharmacyList.add(new PharmacyMedicineSupply("Med 7",medName,supply));
    	pharmacyList.add(new PharmacyMedicineSupply("PharmaOne",medName,supply));
    	pharmacyList.add(new PharmacyMedicineSupply("MediLane",medName,supply));
    	pharmacyList.add(new PharmacyMedicineSupply("Pharma Plus",medName,supply));
    }
   
}

