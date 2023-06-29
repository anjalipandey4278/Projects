package com.nagarro.carInsurance.services;

import com.nagarro.carInsurance.dto.CarDto;
import com.nagarro.carInsurance.enums.CarType;
import com.nagarro.carInsurance.enums.InsuranceType;
import com.nagarro.carInsurance.interfaces.CarService;
import com.nagarro.carInsurance.models.CarModel;

public class CarServiceImpl implements CarService {

	@Override
	public CarDto calculatePremium(CarModel car) {
		CarDto carDto = new CarDto();
		carDto.setCar(car);
		double finalPrice = 0d;
		if (car.getType() == CarType.HATCHBACK) {
			finalPrice = 0.05 * car.getCost();
		} else if (car.getType() == CarType.SEDAN) {
			finalPrice = 0.08 * car.getCost();
		} else if (car.getType() == CarType.SUV) {
			finalPrice = 0.1 * car.getCost();
		}

		if (car.getInsuranceType() == InsuranceType.BASIC) {
			carDto.setPremium(finalPrice);
		} else {
			carDto.setPremium((0.2 * finalPrice) + finalPrice);
		}

		return carDto;

	}
}
