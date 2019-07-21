package com.qa.rest.test;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class Test9_SetRequestData2 {
	
	// *** 1. To path parameters type 2 ***
	@Test
	public void testSetPathParameter2() {
		given()
			.pathParam("type", "json")
			.pathParam("section", "Domains").
		when()
			.post("https://api.fonts.com/rest/{type}/{section}/").
		then()
			.statusCode(400);
	}
	
	// *** 2. Cookies can be set in request param ***
	@Test
	public void testSetCookiesInRequest() {
		
		// to set single value
		given()
			.cookie("__utmt", "1").
		when()
			.get("http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry").
		then()
			.statusCode(200);
	}

	// *** 3. We can pass single header, headers with multiple values and multiple headers ***
	@Test
	public void testSetHeaders() {
		
		given()
			.header("k", "v")
			.header("k10", "val1","val2","val3")
			.header("k1", "v1","k2","v2").
		when()
			.get("https://api.fonts.com/rest/json/Accounts/").
		then()
			.statusCode(400);
	}


	// *** 4. We can ContentType ***
	@Test
	public void testSetContentType() {
		
		given()
			.contentType(ContentType.JSON)
			.contentType("application/json; charset=utf-8").
		when()
			.get("https://api.fonts.com/rest/json/Accounts/").
		then()
			.statusCode(400);
	}
}
