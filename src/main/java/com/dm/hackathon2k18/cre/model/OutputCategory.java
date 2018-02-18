package com.dm.hackathon2k18.cre.model;

import java.util.List;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Rajan.Bhave.
 *         Created Feb 18, 2018.
 */
public class OutputCategory {
	String categoryType;
	private List<OutputComponents> componentsList;
	
	
	/**
	 * Returns the value of the field called 'componentsList'.
	 * @return Returns the componentsList.
	 */
	public List<OutputComponents> getComponentsList() {
		return this.componentsList;
	}
	/**
	 * Sets the field called 'componentsList' to the given value.
	 * @param componentsList The componentsList to set.
	 */
	public void setComponentsList(List<OutputComponents> componentsList) {
		this.componentsList = componentsList;
	}
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param categoryType
	 * @param components
	 */
	public OutputCategory(String categoryType, List<OutputComponents> componentsList) {
		super();
		this.categoryType = categoryType;
		this.componentsList = componentsList;
	}
	/**
	 * Returns the value of the field called 'categoryType'.
	 * @return Returns the categoryType.
	 */
	public String getCategoryType() {
		return this.categoryType;
	}
	/**
	 * Sets the field called 'categoryType' to the given value.
	 * @param categoryType The categoryType to set.
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	/**
	 * Returns the value of the field called 'components'.
	 * @return Returns the components.
	 */
	
	
}
