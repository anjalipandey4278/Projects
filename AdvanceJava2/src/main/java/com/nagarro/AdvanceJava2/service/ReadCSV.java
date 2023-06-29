package com.nagarro.AdvanceJava2.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.AdvanceJava2.HibernetUtil;
import com.nagarro.AdvanceJava2.constant.Constants;
import com.nagarro.AdvanceJava2.csvconverters.DoubleConverter;
import com.nagarro.AdvanceJava2.model.CSVData;


public class ReadCSV {
//	private static final String  = "C:\\Users\\anjalipandey\\nagarro\\anjali-pandey\\AdvanceJava2\\src\\resource";
	private static ArrayList<String> list_of_file = new ArrayList<String>();

	static public ArrayList<String> getAllFiles() {
		try {
			File folder = new File(Constants.CSV_DIRECTORY_PATH);
			for (File file : folder.listFiles()) {
				String name = file.getName();
				if (name.toLowerCase().contains("csv")) {
					list_of_file.add(name);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_of_file;
	}

	static ArrayList<String> csv_data = new ArrayList<String>();
	static ArrayList<String> arr;

	static public ArrayList<String> readCSV() {
		if (list_of_file.size() > 0) {
			// create BufferedReader to read csv file
			for (int i = 0; i < list_of_file.size(); i++) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(Constants.CSV_DIRECTORY_PATH + "/" + list_of_file.get(i)));

					String str_line = "";
					br.readLine();
					while ((str_line = br.readLine()) != null) {

						if (!csv_data.contains(str_line)) {
							StringTokenizer token = new StringTokenizer(str_line, "|");
							arr = new ArrayList(str_line.length());
							while (token.hasMoreTokens()) {
								arr.add(token.nextToken());
							}
							Object[] objArr = arr.toArray();

							// convert Object array to String array
							String[] str = Arrays.copyOf(objArr, objArr.length, String[].class);

							CSVData row = new CSVData();
							row.setShirt_id(str[0]);
							row.setProduct_name(str[1]);
							row.setColour(str[2]);
							row.setGender(str[3]);
							row.setSize(str[4]);
							row.setPrice(DoubleConverter.convert(str[5]));
							row.setRating(DoubleConverter.convert(str[6]));
							row.setProduct_availability(str[7]);

							SessionFactory sessionFactory = HibernetUtil.getSessionFactory();

							Session session = sessionFactory.openSession();
							Transaction tnx = session.beginTransaction();

							session.saveOrUpdate(row);
							tnx.commit();

							csv_data.add(str_line);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Error occurs");
				}
			}
		}
		return csv_data;
	}

	public static ArrayList<String> getCSVData() {
		getAllFiles();
		readCSV();
		return csv_data;
	}


}
