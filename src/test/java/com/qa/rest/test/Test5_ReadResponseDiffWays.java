package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;
import java.io.InputStream;

import io.restassured.response.*;
import io.restassured.http.*;

public class Test5_ReadResponseDiffWays {
	
	// *** 1.To get all response 'asString()'  ***
	@Test
	public void testGetResponseAsString() {
		String responseAsString = get("http://services.groupkt.com/country/search?text=lands").asString();
		System.out.println(" **** My Response ==>> " + responseAsString);
	}
	
	
	// *** 2.To get all response 'asInputStream()'  ***
	@Test
	public void testGetResponseAsInputStream() throws IOException {
		InputStream responseAsInputStream = get("http://services.groupkt.com/country/get/iso2code/cn").asInputStream();
		System.out.println(" **** My Response ==>> " + responseAsInputStream);
		System.out.println("Stream Length ==>> " + responseAsInputStream.toString().length());
		responseAsInputStream.close();
	}
	
	
	// *** 3.To get all response 'asByteArray()'  ***
	@Test
	public void testGetResponseAsByteArray() {
		byte[] responseAsByteArray = get("http://services.groupkt.com/country/search?text=lands").asByteArray();
		System.out.println(" **** My Response ==>> " + responseAsByteArray);
		System.out.println(" Byte Array Length ==>> " + responseAsByteArray);
	}

	// *** 4.To extract all details using 'path()'  ***
	@Test
	public void testExtractDetailsUsingPath() {
		String href =
				when()
					.get("http://jsonplaceholder.typicode.com/photos/1").
				then()
					.contentType(ContentType.JSON)
					.body("albumId", equalTo(1)).
				extract()
					.path("url");
		
		System.out.println(href);
		
		when().get(href).then().statusCode(200);
	}
	

	// *** 5.To extract all details using 'path()' in one line ***
	@Test
	public void testExtractDetailsUsingPathInOneLine() {
		// Type-1
		String href1 = get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		System.out.println("Fetched URL 1 => "+href1);		
		when().get(href1).then().statusCode(200);
		
		// Type-2
		String href2 = get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println("Fetched URL 2 => "+href2);		
		when().get(href2).then().statusCode(200);
	}
	
	// *** 6.To extract all details using 'response()' for future use ***	
	@Test
	public void testExtractDetailsUsingResponse() {
		Response response = 
				when().
					get("http://jsonplaceholder.typicode.com/photos/1").
				then().
				extract()
					.response();
		System.out.println("Content Type ==>> " + response.contentType());
		System.out.println("Href ==> " + response.path("url"));
		System.out.println("Status Code ==>> " + response.statusCode());
	}
	
}



