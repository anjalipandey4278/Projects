package com.nagarro.carInsurance.interfaces;

import com.nagarro.carInsurance.dto.CarDto;
import com.nagarro.carInsurance.models.CarModel;

public interface CarService {

	public CarDto calculatePremium(CarModel car);

}