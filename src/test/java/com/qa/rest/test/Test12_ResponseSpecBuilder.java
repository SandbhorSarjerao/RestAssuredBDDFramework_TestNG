package com.qa.rest.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Test12_ResponseSpecBuilder {

	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void mandatoryCheck() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectHeader("Content-Type", "application/json;charset=UTF-8");
		responseSpec = builder.build();
	}
	
	@Test
	public void testResponse() {
		when()
			.get("http://services.groupkt.com/country/search?text=india").
		then()
			.spec(responseSpec)
			.time(lessThan(5000L));
	}
}
