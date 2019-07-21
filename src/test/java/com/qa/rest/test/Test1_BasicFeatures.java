package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import io.restassured.response.*;
import io.restassured.http.*;

public class Test1_BasicFeatures {
	
	// *** 1.Checking Status Code  ***
	@Test
	public void testStatusCode() {
		given()
			.get("http://jsonplaceholder.typicode.com/posts/3").
		then()
			.statusCode(200);		
	}

	// *** 2.Verify Status Code & Print complete Response in Console ***
	@Test
	public void testLogging() {
		given()
			.get("http://services.groupkt.com/country/get/all").
		then()
			.statusCode(200)
			.log().all();
	}
	
	// *** 3.Verifying Single Content using 'org.hamcrest.Matchers' library's equalTo() method ***
	@Test
	public void testEqualToMethod() {
		given()
			.get("http://services.groupkt.com/country/get/iso2code/").
		then()
			.body("RestResponse.result.name", equalTo("United States of America"));
	}

	// *** 4.Verifying Multiple Content using 'org.hamcrest.Matchers' library's equalTo() method ***
	@Test
	public void testHasItemMethod() {
		given()
			.get("http://services.groupkt.com/country/get/iso2code/").
		then()
			.body("RestResponse.result.name", hasItems("India","Canada","Singapore","Malaysia","Hong Kong","United States of America","United Kingdom of Great Britain and Northern Ireland"));
	}
		
	// *** 5.Parameters and Headers can be set ***
	@Test
	public void testParametersAndHeaders() {
		given()
			.param("key1", "value1")
			.header("header1","header1value").
		when()
			.get("http://services.groupkt.com/country/get/iso2code/gb").
		then()
			.statusCode(200)
			.log().all();
	}
	
	// *** 6. Using 'and()' to increase readability, generally used when writing in one line ***
	@Test
	public void testAndMethodForReadability() {
		given().param("key1", "value1").and().header("header1","header1value").when().get("http://services.groupkt.com/country/get/iso2code/gb").then().statusCode(200).and().body("RestResponse.result.alpha3_code", equalTo("CHN"));
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	