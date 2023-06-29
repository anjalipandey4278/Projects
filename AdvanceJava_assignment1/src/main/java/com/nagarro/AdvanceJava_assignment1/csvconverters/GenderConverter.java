package com.nagarro.AdvanceJava_assignment1.csvconverters;
import com.nagarro.AdvanceJava_assignment1.enums.GenderEnum;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class GenderConverter extends AbstractBeanField<Object> {

	@Override
	protected GenderEnum convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		return GenderEnum.lookup(value);
	}

}
