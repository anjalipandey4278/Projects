package com.nagarro.AdvanceJava2;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

import com.nagarro.AdvanceJava2.constant.Constants;
import com.nagarro.AdvanceJava2.service.DirectoryWatcher;
import com.nagarro.AdvanceJava2.service.ReadCSV;


public class SearchProductMain {
	public static void main(String args[]) throws FileNotFoundException, ParseException, InterruptedException {

		ReadCSV thread = new ReadCSV();
		Thread thread1 = new Thread(new DirectoryWatcher());
		thread1.setName(Constants.THREAD_NAME);
		thread1.setDaemon(true);
		thread1.start();

		// for taking input
		Scanner scanner = new Scanner(System.in);

		String colour, gender, size;
		int choice;

		ArrayList<String> CSV_data = ReadCSV.getCSVData();

		System.out.println("Enter Tshirt colour:");
		colour = scanner.nextLine();
		System.out.print("Enter Tshirt size:");
		size = scanner.nextLine().toUpperCase();
		System.out.print("Enter Gender(M/F)");
		gender = scanner.nextLine().toUpperCase();

		System.out.print("Enter output preference \n 1.cost \n 2.cost and Rating\n" + "");

		choice = scanner.nextInt();
		CSV_data = ReadCSV.getCSVData();

		SearchController sc = new SearchController();
		try {
			sc.search_Product(CSV_data, colour, gender, size);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		sc.updateView(choice);

		scanner.close();
	}
}
