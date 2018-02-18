package com.dm.hackathon2k18.cre.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dm.hackathon2k18.cre.model.CREData;
import com.google.common.collect.Table;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Rajan.Bhave. Created Feb 17, 2018.
 */
public interface CREService {
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param creData
	 */
	public Map<String, Map> compare(CREData componentsMap);

	public String convertToJSON(Map<String, Map> components);
	// public void getComponentsPrice(List<HashMap>components,
	// Table<String,String,String> gcpPricingInfoTable);
}
