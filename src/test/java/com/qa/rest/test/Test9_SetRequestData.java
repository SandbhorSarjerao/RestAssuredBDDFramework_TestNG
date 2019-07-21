package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Test9_SetRequestData {

	// *** 1.Set Different Type of Data in Request Call ***
	// CONNECT used with HTTPS request
	@Test
	public void testConnectRequest() {
		
		when()
			.request("CONNECT","https://api.fonts.com/rest/json/Accounts/").
		then()
			.statusCode(400);
	}
	
	// *** 2.Set Query Parameter in GET Request ***
	@Test
	public void testQueryParameter() {
		given()
			.queryParam("A", "A Val")
			.queryParam("B", "B Val").
		when()
			.get("https://api.fonts.com/rest/json/Accounts").
		then()
			.statusCode(400);
	}

	// *** 3.Form Parameter in POST Request ***
	@Test
	public void testFormParameter() {
		given()
			.formParam("A", "A Val")
			.formParam("B", "B Val").
		when()
			.post("https://api.fonts.com/rest/json/Domains").
		then()
			.statusCode(400);
	}

	/* 4. To set parameters - recommended way 
	 *    If request is GET then param will be treated as QueryParameter
	 *    If request is POST then param will be treated as FormParameter
	 */
	
	@Test
	public void testSetParameters() {
		given()
			.param("A", "A Val")
			.param("B", "B Val").
		when()
			.get("https://api.fonts.com/rest/json/Accounts").
		then()
			.statusCode(400);
	}

	/* 5. To set multiple value parameters 
	 *    
	 *    We can pass list, multiple values or no values in param
	 */
	
	@Test
	public void testSetMultipleValueParameters() {
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		
		given()
			.param("A", "Val1","Val2","Val3")
			.param("B")
			.param("C", list).
		when()
			.get("https://api.fonts.com/rest/json/Accounts").
		then()
			.statusCode(400);
	}
	
}
