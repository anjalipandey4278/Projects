package com.nagarro.AdvanceJava2.csvconverters;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class DoubleConverter {

	public static Double  convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return Double.parseDouble(value);
	}

}
