package com.qa.rest.test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test20_BasicAndDigestiveAuthentications {

	// Type 1 = Challenged Basic Authentication
	// minimum 2 req-response pair required to process a call
	// Rest Assured will not send credentials to server initially. When server explicitly asked for it only when credentials passed to server in headers along with rest of the details.  
	@Test
	public void testBasicChallengedAuthentication() {
		given()
			.auth()
			.basic("userName", "password").
		when()
			.get("http://services.groupkt.com/country/get/all").
		then()
			.statusCode(200);
	}
	
	// Type 2 - Preemptive Basic Authentication - Credential will be passed to server before it ask
	@Test
	public void testBasicPreemptiveAuthontication() {
		given()
			.auth()
			.preemptive()
			.basic("userName", "password").
		when()
			.get("http://services.groupkt.com/country/get/all").
		then()
			.statusCode(200);
	}
	
	// Authentication can be set for all calls 
	@Test
	public void testBasicAuthentication() {
		RestAssured.authentication = basic("userName","password");
		given().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
	}
	
	// Type 3 = Challenged Digest Authentication i.e. minimum 2 req response combination required
	// Digest Authentication is more secure than Basic Authentication as it involve a new Digestive Key
	@Test
	public void testDigestiveAuthontication() {
		given()
			.auth()
			.digest("userName", "password").
		when()
			.get("http://services.groupkt.com/country/get/all").
		then()
			.statusCode(200);
	}
}
