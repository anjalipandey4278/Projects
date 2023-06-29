package com.nagarro.AdvanceJava_assignment1.services;

import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

import com.nagarro.AdvanceJava_assignment1.models.TshirtModel;
import com.nagarro.AdvanceJava_assignment1.utils.Constants;
import com.nagarro.AdvanceJava_assignment1.utils.StorageClass;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCsv {

	public void readAllDataAtOnce() {
		try {
			File[] files = new File(Constants.CSV_DIRECTORY_PATH).listFiles();

			// Arrays.stream(files).forEach(System.out::println);
//
			
			//check for csv file

			for (File file : files) {
				StorageClass.getStorageClass().insertData(file.getName().replaceFirst("[.][^.]+$", "").toLowerCase(),
						getCsvTOBean(file.getAbsolutePath()).parse().stream().collect(Collectors.toSet()));
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readDataFromFile(String filePath, String companyName) {
		try {

			Set<TshirtModel> set = getCsvTOBean(filePath).parse().stream().collect(Collectors.toSet());

			StorageClass.getStorageClass().insertData(companyName.toLowerCase(), set);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CsvToBean<TshirtModel> getCsvTOBean(String file) throws Exception {

		FileReader filereader = new FileReader(file);
		CsvToBean<TshirtModel> csvToBean = new CsvToBeanBuilder<TshirtModel>(filereader).withType(TshirtModel.class)
				.withIgnoreLeadingWhiteSpace(true).build();
		CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).withSkipLines(1).build();

		csvToBean.setCsvReader(csvReader);

		return csvToBean;

	}

}




//// StorageClass.getStorageClass().getData().stream().forEach(System.out::println);
