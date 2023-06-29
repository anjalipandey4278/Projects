package com.nagarro.AdvanceJava2.service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import com.nagarro.AdvanceJava2.constant.Constants;


public class DirectoryWatcher implements Runnable {

	private void watchFolder() {

		try {

			WatchService watchService = FileSystems.getDefault().newWatchService();

			Path directory = Paths.get(Constants.CSV_DIRECTORY_PATH);

			directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			WatchKey key;
			while ((key = watchService.take()) != null) {
				Thread.sleep(5000);

				List<WatchEvent<?>> listOfEvents = key.pollEvents();

				// for (WatchEvent<?> event : key.pollEvents()) {

				WatchEvent<?> event;
				if (listOfEvents.size() == 1
						|| (listOfEvents.get(listOfEvents.size() - 1).kind().name() == "ENTRY_MODIFY")) {
					event = listOfEvents.get(listOfEvents.size() - 1);
				} else {
					event = listOfEvents.get(listOfEvents.size() - 2);
				}

		

				@SuppressWarnings("unchecked")
				WatchEvent<Path> pathEvent = (WatchEvent<Path>) event;

				Path fileName = pathEvent.context();
				int count = event.count();

				WatchEvent.Kind<?> kind = event.kind();

				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {

					System.out.println("A new file is created : " + fileName + " " + event.count());
					System.out.println("doing creation changes");
				}

				if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
					System.out.println("A file has been deleted: " + fileName + " " + event.count());
					System.out.println("doing deletion changes");
				}

				if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

					System.out.println("A file has been modified: " + fileName + " " + event.count());

					if (count >= 1) {

						ReadCSV.getCSVData();
					}

				}

				boolean valid = key.reset();
				if (!valid) {
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void run() {
		watchFolder();
	}

}
