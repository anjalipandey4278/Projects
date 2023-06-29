package com.nagarro.AdvanceJava_assignment1.models;
import java.util.Comparator;
import java.util.function.Predicate;

import com.nagarro.AdvanceJava_assignment1.enums.GenderEnum;
import com.nagarro.AdvanceJava_assignment1.enums.OutputPreferenceEnum;
import com.nagarro.AdvanceJava_assignment1.enums.SizeEnum;

public class InputModel {
	private String color;
	private SizeEnum size;
	private GenderEnum gender;
	private OutputPreferenceEnum outputPreference;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public SizeEnum getSize() {
		return size;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public OutputPreferenceEnum getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(OutputPreferenceEnum outputPreference) {
		this.outputPreference = outputPreference;
	}

	public Predicate<TshirtModel> getColorPredicate() {
		Predicate<TshirtModel> colorPredicate = item -> this.getColor().equalsIgnoreCase(item.getColour());
		return colorPredicate;
	}

	public Predicate<TshirtModel> getSizePredicate() {
		Predicate<TshirtModel> sizePredicate = item -> this.getSize().equals(item.getSize());
		return sizePredicate;
	}

	public Predicate<TshirtModel> getGenderPredicate() {
		Predicate<TshirtModel> genderPredicate = item -> this.getGender().equals(item.getGenderRecomendation());
		return genderPredicate;
	}

	public Comparator<TshirtModel> getComparator() {

		Comparator<TshirtModel> compareByPrice = Comparator.comparing(TshirtModel::getCost);

		Comparator<TshirtModel> compareByRating = Comparator.comparing(TshirtModel::getRating);

		Comparator<TshirtModel> priceAndRating = compareByPrice.thenComparing(compareByRating);

		if (this.outputPreference.compareTo(OutputPreferenceEnum.RATING) == 0) {
			return compareByRating;
		} else if (this.outputPreference.compareTo(OutputPreferenceEnum.PRICEANDRATING) == 0) {
			return priceAndRating;
		} else {
			return compareByPrice;
		}
	}

}
