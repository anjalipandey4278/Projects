package com.nagarro.AdvanceJava_assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.nagarro.AdvanceJava_assignment1.enums.GenderEnum;
import com.nagarro.AdvanceJava_assignment1.enums.OutputPreferenceEnum;
import com.nagarro.AdvanceJava_assignment1.enums.SizeEnum;
import com.nagarro.AdvanceJava_assignment1.models.InputModel;
import com.nagarro.AdvanceJava_assignment1.models.TshirtModel;
import com.nagarro.AdvanceJava_assignment1.services.DirectoryWatcher;
import com.nagarro.AdvanceJava_assignment1.services.ReadCsv;
import com.nagarro.AdvanceJava_assignment1.utils.Constants;
import com.nagarro.AdvanceJava_assignment1.utils.StorageClass;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Application starting!!");
		ReadCsv readCsv = new ReadCsv();
		readCsv.readAllDataAtOnce();
		Scanner scanner = new Scanner(System.in);

		Thread thread = new Thread(new DirectoryWatcher());
		thread.setName(Constants.THREAD_NAME);
		thread.setDaemon(true);
		thread.start();

		System.out.println(Constants.ENTER_DETAILS);
		String doRepeat = "y";
		while (doRepeat.equalsIgnoreCase("y")) {
			// Take input
			InputModel inputModel = new InputModel();
			String inputData = scanner.nextLine();
			// String input = "-color Black -size L -gender F -outputPreference Price and
			// Rating";

			List<String> features = new ArrayList<>(Arrays.asList(inputData.split("-")));
			features.remove(0);
			for (String feature : features) {
				feature = feature.trim().replaceFirst("\\s", "=").replaceAll("\\s+", " ");
				String[] keyValue = feature.split("=");
				switch (keyValue[0].toLowerCase()) {
				case Constants.COLOR_LOWER:
					inputModel.setColor(keyValue[1]);
					break;
				case Constants.SIZE_LOWER:
					inputModel.setSize(SizeEnum.lookup(keyValue[1]));
					break;
				case Constants.GENDER_LOWER:
					inputModel.setGender(GenderEnum.lookup(keyValue[1]));
					break;
				case Constants.OUTPUT_LOWER:
					inputModel.setOutputPreference(OutputPreferenceEnum.lookup(keyValue[1].replaceAll("\\s+", "")));
					break;
				default:
					// throw new CustomException(Constants.INVALID_FEATURE);
					throw new RuntimeException("Invalid input !");
				}
			}

			List<TshirtModel> resultSet = StorageClass.getStorageClass().getData().stream()
					.filter(inputModel.getColorPredicate().and(inputModel.getSizePredicate())
							.and(inputModel.getGenderPredicate()))
					.sorted(inputModel.getComparator()).collect(Collectors.toList());

			if (!resultSet.isEmpty()) {
				resultSet.stream().forEach(System.out::println);
			} else {
				System.out.println(Constants.NO_RESULT_FOUND);
			}

			System.out.println(Constants.ENTER_AGAIN);
			doRepeat = scanner.nextLine();
		}

		System.out.println(Constants.THANK_YOU);
		scanner.close();

	}
}
