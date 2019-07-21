package com.qa.rest.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Test14_Logging {

	// *** 1. Log for Headers, Body, Cookies
	@Test
	public void testLogging() {
		given()
			.get("http://services.groupkt.com/country/search?text=states").
		then()
			.log().headers();
		//  .log().body();
		//  .log().cookies();
		//  .log().all();
	}

	// *** 2. Log only incase of Errors
	@Test
	public void testLoggingIfErrors() {
		given()
		.get("http://services.groupkt.com/country/search?text=states").
	  //.get("https://api.fonts.com/rest/json/Domains").	
	then()
		.log().ifError();
	}


	// *** 3. Conditional Logging
	@Test
	public void testConditionalLogging() {
		given()
			.get("https://api.fonts.com/rest/json/Domains").	
	then()
		.log().ifStatusCodeIsEqualTo(200);
	}
}

