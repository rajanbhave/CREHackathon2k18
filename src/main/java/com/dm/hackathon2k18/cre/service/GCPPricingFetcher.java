package com.dm.hackathon2k18.cre.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

public class GCPPricingFetcher {
	public static List<String> ignoreComponentAttrValues = Lists
			.newArrayList(new String[] { "shared", "Shared CPU, not guaranteed" });

	public Table<String, String, String> parsePricingJSON() throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		Table<String, String, String> gcpPricingInfoTable = HashBasedTable.create();

		JSONObject jo = (JSONObject) new JSONParser()
				.parse(new FileReader("D://Rajan//OneDrive//Work//Projects//Hackathon//pricelist.json"));

		Set keySet = jo.keySet();
		for (Iterator iterator = keySet.iterator(); iterator.hasNext();) { // 1
			String key = (String) iterator.next();
			JSONObject computeCategories = (JSONObject) jo.get(key);
			Set componentsKeySet = computeCategories.keySet();
			for (Iterator componentsIterator = componentsKeySet.iterator(); componentsIterator.hasNext();) { // 2
				String componentKey = (String) componentsIterator.next();
				System.out.println("COmpnentkey====" + componentKey);
				if (componentKey.equals("CP-BIGQUERY-GENERAL")) {
					System.out.println("Yessss");
				}
				Object obj = computeCategories.get(componentKey);
				if (obj instanceof JSONObject) {
					JSONObject componentValue = (JSONObject) obj;
					Set componentAttrs = componentValue.keySet();
					for (Iterator componentValIterator = componentAttrs.iterator(); componentValIterator.hasNext();) {// 3
						String componentAttr = (String) componentValIterator.next();
						Object objVal = componentValue.get(componentAttr);
						if (objVal instanceof String) {
							String componentAttrVal = String.valueOf(objVal);
							if (!ignoreComponentAttrValues.contains(componentAttrVal)) {
								gcpPricingInfoTable.put(componentKey, componentAttr, componentAttrVal);
							}
						} else if (objVal instanceof JSONObject) {
							JSONObject componentAttrValObj = (JSONObject) objVal;
							Set<String> componentAttrInnerAttrs = componentAttrValObj.keySet();
							for (String componentAttrInnerAttr : componentAttrInnerAttrs) {
								String componentAttrInnerVal = String
										.valueOf(componentAttrValObj.get(componentAttrInnerAttr));
								gcpPricingInfoTable.put(componentKey, componentAttr,
										componentAttrInnerAttr + "|" + componentAttrInnerVal);
							}
						}
					}
				} else {
					String componentAttr = String.valueOf(obj);
					gcpPricingInfoTable.put(componentKey, componentKey, componentAttr);
				}
			}
		}
		System.out.println(gcpPricingInfoTable.rowKeySet());
		/*
		 * for (Table.Cell<String, String, Double> cell : gcpPricingInfoTable.cellSet())
		 * { if ((((String)
		 * cell.getRowKey()).equals("CP-COMPUTEENGINE-VMIMAGE-F1-MICRO")) && (((String)
		 * cell.getColumnKey()).equals("us"))) {
		 * System.out.println("Price Factor per unit per GB " + cell.getValue()); } }
		 */
		return gcpPricingInfoTable;
	}

}
