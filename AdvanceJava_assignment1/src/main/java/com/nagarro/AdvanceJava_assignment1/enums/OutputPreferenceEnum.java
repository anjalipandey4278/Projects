package com.nagarro.AdvanceJava_assignment1.enums;

public enum OutputPreferenceEnum {
	PRICE, RATING, PRICEANDRATING;

	public static OutputPreferenceEnum lookup(String preference) {
		for (OutputPreferenceEnum type : OutputPreferenceEnum.values()) {
			if (type.name().equalsIgnoreCase(preference)) {
				return type;
			}
		}
		return null;
	}

}
