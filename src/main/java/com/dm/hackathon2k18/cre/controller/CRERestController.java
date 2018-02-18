package com.dm.hackathon2k18.cre.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dm.hackathon2k18.cre.model.CREData;
import com.dm.hackathon2k18.cre.model.Category;
import com.dm.hackathon2k18.cre.service.CREService;
import com.dm.hackathon2k18.cre.service.CREServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class CRERestController {

	// @Autowired
	// UserService userService; //Service which will do all data
	// retrieval/manipulation work

	// -------------------Retrieve All
	// Users--------------------------------------------------------

	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.GET) public
	 * ResponseEntity<List<User>> listAllUsers() { List<User> users =
	 * userService.findAllUsers(); if(users.isEmpty()){ return new
	 * ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return
	 * HttpStatus.NOT_FOUND } return new ResponseEntity<List<User>>(users,
	 * HttpStatus.OK); }
	 */

	// -------------------Add a
	// User--------------------------------------------------------

	@RequestMapping(value = "/submit/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> submitCREForm(@RequestBody String json) {
		System.out.println("JSON : " + json);
		json = "{\"types\":[{\"categoryType\":\"storage\",\"quesChoiceMap\":{\"q1\":\"1\",\"q2\":\"1\",\"q3\":\"2\",\"q4\":\"1\",\"q5\":\"1\",\"q6\":\"1\",\"q7\":\"1\",\"q8\":\"2\",\"q9\":\"1\",\"q10\":\"2\"}},{\"categoryType\":\"compute\",\"quesChoiceMap\":{\"q1\":\"0\",\"q2\":\"1\",\"q3\":\"0\",\"q4\":\"1\"}},{\"categoryType\":\"network\",\"quesChoiceMap\":{\"q1\":\"0\",\"q2\":\"1\",\"q3\":\"0\",\"q4\":\"1,4,2\"}}]}";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		CREData creData = gson.fromJson(json, CREData.class);
		CREService creService = new CREServiceImpl();
		Map<String, Map> catCompDescMap = creService.compare(creData);
		String outputJSON = creService.convertToJSON(catCompDescMap);
		List<Category> categoryList = creData.getCategories();
		return new ResponseEntity<String>(outputJSON, HttpStatus.OK);
	}
}