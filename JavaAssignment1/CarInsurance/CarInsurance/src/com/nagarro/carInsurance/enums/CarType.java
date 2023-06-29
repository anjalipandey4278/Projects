package com.nagarro.carInsurance.enums;

public enum CarType {
	HATCHBACK, SEDAN, SUV;
	
	

	public static CarType lookup(String carType) {
		for (CarType type : CarType.values()) {
			if (type.name().equalsIgnoreCase(carType)) {
				return type;
			}
		}
		return null;
	}
}
