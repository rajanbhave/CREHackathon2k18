package com.dm.hackathon2k18.cre.model;

import java.util.Map;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Rajan.Bhave. Created Feb 18, 2018.
 */
public class OutputComponents {
	public String componentName;
	public String componentDescription;
	
	
	

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param componentName
	 * @param componentDescription
	 */
	public OutputComponents(String componentName, String componentDescription) {
		super();
		this.componentName = componentName;
		this.componentDescription = componentDescription;
	}

	/**
	 * Returns the value of the field called 'componentName'.
	 * 
	 * @return Returns the componentName.
	 */
	public String getComponentName() {
		return this.componentName;
	}

	/**
	 * Sets the field called 'componentName' to the given value.
	 * 
	 * @param componentName
	 *            The componentName to set.
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	/**
	 * Returns the value of the field called 'componentDescription'.
	 * 
	 * @return Returns the componentDescription.
	 */
	public String getComponentDescription() {
		return this.componentDescription;
	}

	/**
	 * Sets the field called 'componentDescription' to the given value.
	 * 
	 * @param componentDescription
	 *            The componentDescription to set.
	 */
	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}

}
