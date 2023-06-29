package com.nagarro.AdvanceJava_assignment1.services;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

import com.nagarro.AdvanceJava_assignment1.utils.Constants;

public class DirectoryWatcher implements Runnable {

	private void watchFolder() {

		try {

			WatchService watchService = FileSystems.getDefault().newWatchService();

			Path directory = Paths.get(Constants.CSV_DIRECTORY_PATH);

			directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);

			WatchKey key;
			while ((key = watchService.take()) != null) {

				// Follow this url for info ->
				// https://stackoverflow.com/questions/16777869/java-7-watchservice-ignoring-multiple-occurrences-of-the-same-event
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
				/*
				 * Directory entry modified. When a directory is registered for this event then
				 * the WatchKey is queued when it is observed that an entry in the directory has
				 * been modified. The event count for this event is 1 or greater.
				 */

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

						ReadCsv readCsv = new ReadCsv();
						readCsv.readDataFromFile(directory.toString() + "//" + fileName.toString(),
								fileName.toString().replaceFirst("[.][^.]+$", ""));
						// System.out.println("doing modification changes");
					}

				}

				// }

				// Reset the watch key everytime for continuing to use it for further
				// event polling
				boolean valid = key.reset();
				if (!valid) {
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		watchFolder();
	}

}
