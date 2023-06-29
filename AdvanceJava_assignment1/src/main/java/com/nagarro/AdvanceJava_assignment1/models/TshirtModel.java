package com.nagarro.AdvanceJava_assignment1.models;
import java.util.Objects;

import com.nagarro.AdvanceJava_assignment1.csvconverters.CostConverter;
import com.nagarro.AdvanceJava_assignment1.csvconverters.GenderConverter;
import com.nagarro.AdvanceJava_assignment1.csvconverters.RatingConverter;
import com.nagarro.AdvanceJava_assignment1.csvconverters.SizeConverter;
import com.nagarro.AdvanceJava_assignment1.enums.GenderEnum;
import com.nagarro.AdvanceJava_assignment1.enums.SizeEnum;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

public class TshirtModel {
	@CsvBindByPosition(position = 0)
	// @CsvBindByName(column = "ID")
	private String id;
	@CsvBindByPosition(position = 1)
	// @CsvBindByName(column = "NAME")
	private String name;
	@CsvBindByPosition(position = 2)
	private String colour;
	@CsvCustomBindByPosition(position = 3, converter = GenderConverter.class)
	private GenderEnum genderRecomendation;
	@CsvCustomBindByPosition(position = 4, converter = SizeConverter.class)
	private SizeEnum size;
	@CsvCustomBindByPosition(position = 5, converter = CostConverter.class)
	private double cost;
	@CsvCustomBindByPosition(position = 6, converter = RatingConverter.class)
	private double rating;
	@CsvBindByPosition(position = 7)
	private String availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public GenderEnum getGenderRecomendation() {
		return genderRecomendation;
	}

	public void setGenderRecomendation(GenderEnum genderRecomendation) {
		this.genderRecomendation = genderRecomendation;
	}

	public SizeEnum getSize() {
		return size;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		TshirtModel other = (TshirtModel) obj;
		return Objects.equals(id, other.getId());
	}

	@Override
	public String toString() {
		return "TshirtModel [id=" + id + ", name=" + name + ", colour=" + colour + ", genderRecomendation="
				+ genderRecomendation + ", size=" + size + ", cost=" + cost + ", rating=" + rating + ", availability="
				+ availability + "]";
	}

}
