package com.nagarro.AdvanceJava_assignment1.csvconverters;

import com.nagarro.AdvanceJava_assignment1.enums.SizeEnum;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;


public class SizeConverter extends AbstractBeanField<Object> {

	@Override
	protected SizeEnum convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return SizeEnum.lookup(value);
	}

}
