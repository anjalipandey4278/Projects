package com.nagarro.AdvanceJava_assignment1.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.nagarro.AdvanceJava_assignment1.models.TshirtModel;

public class StorageClass {

	private static StorageClass storageClass;

	private Map<String, Set<TshirtModel>> tshirtCollection = new HashMap<>();
	// private Map<String, Set<TshirtModel>> tshirtCollection = new
	// ConcurrentHashMap<>();
	// private Map<String, Set<TshirtModel>> tshirtCollection =
	// Collections.synchronizedMap(new HashMap<>());

	private StorageClass() {
		super();
	}

	public static StorageClass getStorageClass() {
		if (storageClass == null) {
			storageClass = new StorageClass();
		}
		return storageClass;
	}

	public synchronized void insertData(String type, Set<TshirtModel> data) {

		if (!tshirtCollection.containsKey(type) || tshirtCollection.get(type) == null) {
			tshirtCollection.put(type, data);
		} else {
			tshirtCollection.get(type).addAll(data);
		}
	}

	public synchronized Set<TshirtModel> getData() {
		Set<TshirtModel> result = new HashSet<>();
		tshirtCollection.forEach((K, V) -> {
			result.addAll(V);
		});

		return result;

	}

}
