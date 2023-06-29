package com.nagarro.carInsurance.enums;

public enum InsuranceType {
	BASIC, PREMIUM;
	
	public static InsuranceType lookup(String insuranceType) {
		for (InsuranceType type : InsuranceType.values()) {
			if (type.name().equalsIgnoreCase(insuranceType)) {
				return type;
			}
		}
		return null;
	}

}
