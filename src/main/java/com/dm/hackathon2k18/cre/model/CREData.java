package com.dm.hackathon2k18.cre.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CREData {
	@SerializedName("types")
	private List<Category> categories;

	/**
	 * Returns the value of the field called 'categories'.
	 * 
	 * @return Returns the categories.
	 */
	public List<Category> getCategories() {
		return this.categories;
	}

	/**
	 * Sets the field called 'categories' to the given value.
	 * 
	 * @param categories
	 *            The categories to set.
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}