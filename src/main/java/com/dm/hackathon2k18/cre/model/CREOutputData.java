package com.dm.hackathon2k18.cre.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CREOutputData {
	@SerializedName("types")
	private List<OutputCategory> categories;

	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param categories
	 */
	public CREOutputData(List<OutputCategory> categories) {
		super();
		this.categories = categories;
	}

	/**
	 * Returns the value of the field called 'categories'.
	 * 
	 * @return Returns the categories.
	 */
	public List<OutputCategory> getCategories() {
		return this.categories;
	}

	/**
	 * Sets the field called 'categories' to the given value.
	 * 
	 * @param categories
	 *            The categories to set.
	 */
	public void setCategories(List<OutputCategory> categories) {
		this.categories = categories;
	}

}