package com.cognizant.pharmacymanagement.WebPortal.Model;



public class PharmacyMedicineSupply {
	private String pharmacyName;
	private String medicineName;
	private int supplyCount;
	
	public String getPharmacyName() {
		return pharmacyName;
	}
	
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public int getSupplyCount() {
		return supplyCount;
	}

	public void setSupplyCount(int supplyCount) {
		this.supplyCount = supplyCount;
	}
	
	public PharmacyMedicineSupply(String pharmacyName, String medicineName, int supplyCount) {
		super();
		this.pharmacyName = pharmacyName;
		this.medicineName = medicineName;
		this.supplyCount = supplyCount;
	}
	 @Override
	    public String toString() {
	        return String.format(
	                "PharmacyMedicineSupply [pharmacyName=%s, medicineName=%s, supplyCount=%d]", pharmacyName,
	                medicineName, supplyCount);
		
	}
}

