package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.lang.String;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import io.restassured.http.*;

public class Test6_GroovyFeatures {

	// *** 1.To verify the response contains expected Element  ***
	@Test
	public void testElementPresent() {
		given()
			.get("http://services.groupkt.com/country/search?text=lands").
		then()
		.body("RestResponse.result.name", hasItems("Cayman Islands","Cook Islands")).log().all();
	}

	@Test
	public void testLengthOfResponse() {
		given()
			.get("http://services.groupkt.com/country/search?text=islands").
		then()
		.body("RestResponse.result.alpha3_code*.length().sum()", greaterThan(40));
	}

	// *** 2.To get all attributes as List<String>  ***
	@Test
	public void testGetResponseAsList() {
		String response = get("http://services.groupkt.com/country/search?text=lands").asString();
		
	//	List<String> ls = from(response).getList("RestResponse.result.name");
		
	//	System.out.println("ListSize: " + ls.size());
	//	for(String country :ls)
		{
	//		if(country.equals("Solomon Islands"))
	//			System.out.println("Found my place");
		}		
	}
	

	// *** 3.To get all attributes as List<String> and apply some conditions on it ***
	// The groovy has an implicit variable called 'it' which represents the current item in the list
	@Test
	public void testConditionsOnList() {
		String response = get("http://services.groupkt.com/country/search?text=lands").asString();
	//	List<String> ls = from(response).getList("RestResponse.result.findAll { it.name.length() > 40 }.name");
	//	System.out.println(ls);
	}
	
}










