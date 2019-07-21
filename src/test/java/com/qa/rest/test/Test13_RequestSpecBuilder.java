package com.qa.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Test13_RequestSpecBuilder {

	RequestSpecification requestSpec;
	
	@BeforeClass
	public void mandatoryCheck() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addParam("parameter1","parameterValue");
		builder.addHeader("Content-Type", "application/json;charset=UTF-8");
		requestSpec = builder.build();
	}
	
	@Test
	public void testRequest() {
		given()
			.spec(requestSpec).
		when()
			.get("https://api.fonts.com/rest/json/Accounts/").
		then()
			.statusCode(400)
			.log().all();
	}
}
