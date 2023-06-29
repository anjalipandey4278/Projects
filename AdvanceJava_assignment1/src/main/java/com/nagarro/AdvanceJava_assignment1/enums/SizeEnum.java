package com.nagarro.AdvanceJava_assignment1.enums;

public enum SizeEnum {
	S, M, L, XL, XXL;

	public static SizeEnum lookup(String size) {
		for (SizeEnum type : SizeEnum.values()) {
			if (type.name().equalsIgnoreCase(size)) {
				return type;
			}
		}
		return null;
	}

}
