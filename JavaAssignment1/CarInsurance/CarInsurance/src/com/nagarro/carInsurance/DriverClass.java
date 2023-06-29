package com.nagarro.carInsurance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.nagarro.carInsurance.enums.CarType;
import com.nagarro.carInsurance.enums.InsuranceType;
import com.nagarro.carInsurance.exception.CustomException;
import com.nagarro.carInsurance.interfaces.CarService;
import com.nagarro.carInsurance.models.CarModel;
import com.nagarro.carInsurance.services.CarServiceImpl;
import com.nagarro.carInsurance.utils.Constants;

public class DriverClass {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			CarService carService = new CarServiceImpl();
			List<CarModel> data = new ArrayList<>();
			System.out.println(Constants.ENTER_DETAILS);
			String doRepeat = "yes";
			while (doRepeat.equalsIgnoreCase("yes")) {
				// Take input
				CarModel car = new CarModel();
				String inputData = scanner.nextLine();
				// String s = "-model Tata motors -type HatchBack -price 500000 -insuranceType Basic";
				List<String> arrs = new ArrayList<>(Arrays.asList(inputData.split("-")));
				arrs.remove(0);
				for (String arr : arrs) {
					arr = arr.trim().replaceFirst("\\s", "=").replaceAll("\\s+", " ");
					String[] values = arr.split("=");
					switch (values[0].toLowerCase()) {
					case "model":
						car.setModel(values[1]);
						break;
					case "type":
						car.setType(CarType.lookup(values[1]));
						break;
					case "price":
						car.setCost(Double.parseDouble(values[1]));
						break;
					case "insurancetype":
						car.setInsuranceType(InsuranceType.lookup(values[1]));
						break;
					default:
						throw new CustomException(Constants.INVALID_FEATURE);
					}
				}
				data.add(car);
				System.out.println(Constants.MORE_DETAILS);
				doRepeat = scanner.nextLine();
				// scanner.nextLine();
			}

			for (CarModel car : data) {
				System.out.println(carService.calculatePremium(car));
			}

		} catch (Exception e) {
			System.out.print(e.getLocalizedMessage());
		}

	}

}
