package com.dm.hackathon2k18.cre.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dm.hackathon2k18.cre.model.CREData;
import com.dm.hackathon2k18.cre.model.CREOutputData;
import com.dm.hackathon2k18.cre.model.Category;
import com.dm.hackathon2k18.cre.model.OutputCategory;
import com.dm.hackathon2k18.cre.model.OutputComponents;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * TODO Put here a description of what this class does.
 *
 * @author Rajan.Bhave. Created Feb 17, 2018.
 */
public class CREServiceImpl implements CREService {
	@Override
	public Map<String, Map> compare(CREData creData) {
		Map<String, Map> componentsMap = Maps.newHashMap();
		HashMap<String, String> storageComponents = new HashMap();
		List<Category> categoryList = creData.getCategories();
		for (Category category : categoryList) {
			if (category.getCategoryType().equalsIgnoreCase("Storage")) {
				Map<String, String> computeQuesChoiceMap = category.getQuesChoiceMap();
				String component;
				if (computeQuesChoiceMap.get("q1").equals("1") || computeQuesChoiceMap.get("q1").equals("2")) {

					if (computeQuesChoiceMap.get("q2").equals("1")) {

						component = "BigQuery/Big Table";
						if (computeQuesChoiceMap.get("q6").equals("1")) {

							component = "BigQuery";
							storageComponents.put(component, "This is used to Analytics");

						}
						if (computeQuesChoiceMap.get("q7").equals("1")) {

							component = "BigTable";
							storageComponents.put(component, "");

						}
					} else if (computeQuesChoiceMap.get("q2").equals("2")) {

						component = "Cloud SQL/ Cloud Spanner/Cloud Firestore for firebase/ cloud datastore";

						if (computeQuesChoiceMap.get("q3").equals("1")) {

							component = "cloudsql/cloudspanner";

							if (computeQuesChoiceMap.get("q4").equals("1")) {

								component = "CloudSpanner";
								storageComponents.put(component, "");

							} else {

								component = "CloudSql";
								storageComponents.put(component, "");

							}

						} else if (computeQuesChoiceMap.get("q3").equals("2")) {

							component = "Cloud Firestore for Firebase/Cloud Datastore";

							if (computeQuesChoiceMap.get("q5").equals("1")) {

								component = "Cloud Firestore for Firebase";
								storageComponents.put(component, "");

							} else {
								component = "Cloud Datastore";
								storageComponents.put(component, "");
							}
						}
					}

				} else if (computeQuesChoiceMap.get("q1").equals("3")) {

					component = "Cloud Storage for Firebase/Google Cloud Storage";

					if (computeQuesChoiceMap.get("q8").equals("1")) {

						component = "Cloud Storage for Firebase";
						storageComponents.put(component, "");

					} else {
						component = "Google Cloud Storage";
						if (computeQuesChoiceMap.get("q11").equals("1")) {

							component = "Multi-Regional";
							storageComponents.put(component, "Google Cloud Storage~Multi-Regional Bucket");

						} else if (computeQuesChoiceMap.get("q11").equals("2")) {

							component = "Regional";
							storageComponents.put(component, "Google Cloud Storage~Regional Bucket");

						} else if (computeQuesChoiceMap.get("q11").equals("3")) {

							component = "Nearline";
							storageComponents.put(component, "Google Cloud Storage~Nearline");

						} else if (computeQuesChoiceMap.get("q11").equals("4")) {

							component = "Coldline";
							storageComponents.put(component, "Google Cloud Storage~Coldline");
						}
					}
				}
				if (computeQuesChoiceMap.get("q9").equals("1")) {

					component = "Google Drive";
					storageComponents.put(component, "Google Drive");

				}
				if (computeQuesChoiceMap.get("q10").equals("1")) {

					component = "Persistent Disk";
					storageComponents.put(component,"description");

				}

			} else if (category.getCategoryType().equalsIgnoreCase("Ingest")) {

			} else if (category.getCategoryType().equalsIgnoreCase("Process")) {

			}
		}
		componentsMap.put("Storage", storageComponents);
		return componentsMap;
	}

	/*
	 * public void getComponentsPrice(List<HashMap> components, Table<String,
	 * String, String> gcpPricingInfoTable) { Set<String> pricingJSONCompSet =
	 * gcpPricingInfoTable.rowKeySet(); HashMap<String, Map> componentAttributesMap
	 * = Maps.newHashMap(); for (HashMap<String, String> componentsMap : components)
	 * { Set<String> componentsSet = componentsMap.keySet(); for (Iterator compItr =
	 * components.iterator(); compItr.hasNext();) { String component = (String)
	 * compItr.next(); for (String pricingJSONComp : pricingJSONCompSet) { if
	 * (StringUtils.containsIgnoreCase(pricingJSONComp, component)) { Map
	 * pricingJSONCompAttrs = gcpPricingInfoTable.row(pricingJSONComp);
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * } }
	 */

	public String convertToJSON(Map<String, Map> catComponentsMap) {
		Set<String> categories = catComponentsMap.keySet();
		List<OutputCategory> outCatList = Lists.newArrayList();
		List<OutputComponents> outCompList = Lists.newArrayList();
		for (String categoryType : categories) {
			Map<String, String> componentsMap = catComponentsMap.get(categoryType);
			Set<String> componentsSet = componentsMap.keySet();
			for (String componentName : componentsSet) {
				String description = componentsMap.get(componentName);
				OutputComponents outComp = new OutputComponents(componentName, description);
				outCompList.add(outComp);
			}
			OutputCategory outCat = new OutputCategory(categoryType, outCompList);
			outCatList.add(outCat);

		}
		CREOutputData outData = new CREOutputData(outCatList);
		Gson gson = new Gson();
		String jsonStringFromObj = gson.toJson(outData);
		return jsonStringFromObj;
	}
}
