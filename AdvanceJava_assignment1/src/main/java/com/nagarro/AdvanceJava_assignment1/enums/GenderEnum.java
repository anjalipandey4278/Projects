package com.nagarro.AdvanceJava_assignment1.enums;

public enum GenderEnum {
	M, F, U;

	public static GenderEnum lookup(String gender) {
		for (GenderEnum type : GenderEnum.values()) {
			if (type.name().equalsIgnoreCase(gender)) {
				return type;
			}
		}
		return null;
	}

	public static String getFullForm(GenderEnum gender) {
		String fullForm = null;
		if (gender.compareTo(GenderEnum.M) == 0)
			fullForm = "Male";
		else if (gender.compareTo(GenderEnum.F) == 0)
			fullForm = "Female";
		else if (gender.compareTo(GenderEnum.U) == 0)
			fullForm = "Unisex";

		return fullForm;

	}

}
