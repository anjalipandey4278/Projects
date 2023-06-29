package com.nagarro.AdvanceJava_assignment1.csvconverters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CostConverter extends AbstractBeanField<Object> {

	@Override
	protected Double convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return Double.parseDouble(value);
	}

}
