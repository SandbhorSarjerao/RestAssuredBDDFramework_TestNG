package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import io.restassured.response.*;
import io.restassured.http.*;

public class Test4_PostRequest {
	
	@Test
	public void testPostRequest() {
		given()
			.param("", "")
			.param("", "")
			.headers("", "")
			.headers("", "").
		when()
			.post("").
		then()
			.statusCode(201).log().all();
	}
}
