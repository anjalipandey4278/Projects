package com.nagarro.carInsurance.dto;

import com.nagarro.carInsurance.models.CarModel;

public class CarDto {
	
	private CarModel car;
	
	private double premium;

	public CarModel getCar() {
		return car;
	}

	public void setCar(CarModel car) {
		this.car = car;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return  car + ", premium=" + premium;
	}
	
	

}
