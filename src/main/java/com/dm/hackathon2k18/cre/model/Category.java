package com.dm.hackathon2k18.cre.model;
import java.util.Map;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Rajan.Bhave. Created Feb 17, 2018.
 */
public class Category {
	String categoryType;
	private Map<String, String> quesChoiceMap;

	/**
	 * Returns the value of the field called 'quesChoiceMap'.
	 * 
	 * @return Returns the quesChoiceMap.
	 */
	public Map<String, String> getQuesChoiceMap() {
		return this.quesChoiceMap;
	}

	/**
	 * Sets the field called 'quesChoiceMap' to the given value.
	 * 
	 * @param quesChoiceMap
	 *            The quesChoiceMap to set.
	 */
	public void setQuesChoiceMap(Map<String, String> quesChoiceMap) {
		this.quesChoiceMap = quesChoiceMap;
	}

	/**
	 * Returns the value of the field called 'categoryType'.
	 * 
	 * @return Returns the categoryType.
	 */
	public String getCategoryType() {
		return this.categoryType;
	}

	/**
	 * Sets the field called 'categoryType' to the given value.
	 * 
	 * @param categoryType
	 *            The categoryType to set.
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
}
