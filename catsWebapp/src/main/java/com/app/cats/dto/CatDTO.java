package com.app.cats.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class CatDTO {

	@NotBlank
	private String name;

	@NotBlank
	@Pattern(regexp="[0-3]?[0-9]\\.[0-1]?[0-9]\\.[1-2][0-9]{3}")
	private String dateOfBirth;
	
	@NotNull
	private Float weight;
	
	@NotBlank
	private String catOwnerName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void getDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getCatOwnerName() {
		return catOwnerName;
	}

	public void setCatOwnerName(String catOwnerName) {
		this.catOwnerName = catOwnerName;
	}

}
