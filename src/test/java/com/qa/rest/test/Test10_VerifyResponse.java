package com.qa.rest.test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matcher.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.matcher.ResponseAwareMatcherComposer;

public class Test10_VerifyResponse {
	
	// *** 1. Status Code Verification in Response ***
	@Test
	public void testStatusInResponse() {
		given()
			.get("http://jsonplaceholder.typicode.com/photos/").
		then()
			.assertThat()
				.statusCode(200)
				.log().all();
		
		given().get("http://jsonplaceholder.typicode.com/photos/").then()
			.assertThat()
			.statusLine("HTTP/1.1 200 OK");

		given().get("http://jsonplaceholder.typicode.com/photos/").then()
		.assertThat()
		.statusLine(containsString("OK"));
	}

	// *** 2. Headers Verification in Response ***
	@Test
	public void testHeadersInResponse() {
		given().get("http://jsonplaceholder.typicode.com/photos/").then()
		.assertThat()
		.header("X-Powered-By","Express");

		given().get("http://jsonplaceholder.typicode.com/photos/").then()
		.assertThat()
		.headers("Vary","Accept-Encoding","Content-Type",containsString("json"));
	}

	// *** 3. ContentType Verification in Response ***
	@Test
	public void testContentTypeInResponse() {
		given().get("http://jsonplaceholder.typicode.com/photos/").then()
		.assertThat()
		.contentType(ContentType.JSON);
	}

	// *** 4. Body Verification in Response ***
	@Test
	public void testBodyInResponse() {
		String responseString = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").asString();

		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").then()
		.assertThat()
		.body(equalTo(responseString));
	}


	// *** 5. Body Attribute Verification using Java8 Lambda Expressions in Response ***
	@Test
	public void testBodyParametersInResponse() {

		given().get("http://jsonplaceholder.typicode.com/photos/1").
		then()
			.body("thumbnailUrl", new ResponseAwareMatcher<Response>()
				{
					public Matcher<?> matcher(Response response)
					{
						return equalTo("http://placehold.it/150/92c952");
					}
				});
		
		// With Java8 Lambda Expressions 
		given().get("http://jsonplaceholder.typicode.com/photos/1").
		then()
			.body("thumbnailUrl", response -> equalTo("http://placehold.it/150/92c952"));
					
					
		given().get("http://jsonplaceholder.typicode.com/photos/1").
		then()
			.body("thumbnailUrl", endsWith("92c952"));
	}	

	// *** 6. Cookies Key & Value Verification in Response ***
	@Test
	public void testCookiesInResponse() {

		given().get("http://jsonplaceholder.typicode.com/comments").
		then()
			.log().all()
			.assertThat()
			.cookie("","");
	}
}
