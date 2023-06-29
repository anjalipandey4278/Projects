package com.nagarro.carInsurance.models;

import com.nagarro.carInsurance.enums.CarType;
import com.nagarro.carInsurance.enums.InsuranceType;
import com.nagarro.carInsurance.exception.CustomException;
import com.nagarro.carInsurance.utils.Constants;

public class CarModel {

	private String model;
	private CarType type;
	private double cost;
	private InsuranceType insuranceType;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		if(type == null) {
			throw new CustomException(Constants.INVALID_CAR_TYPE);
		}
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		if(insuranceType == null) {
			throw new CustomException(Constants.INVALID_INSURANCE_TYPE);
		}
		this.insuranceType = insuranceType;
	}


	@Override
	public String toString() {
		return "Car->" + "model='" + model + '\'' + ", type=" + type.name() + ", cost=" + cost + ", insuranceType='"
				+ insuranceType.name() + '\'';
	}
}
