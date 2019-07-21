package com.qa.rest.test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import io.restassured.RestAssured;

public class Test16_HandlingSSL_TLS {
	@BeforeClass
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	@Test
	public void testSSL() {
		given().relaxedHTTPSValidation().when().get("http://www.bupa.com.au/").
		then().statusCode(200);
	}
	

	@Test
	public void testTLS() {
		given().relaxedHTTPSValidation("TLS").when().get("http://www.bupa.com.au/").
		then().statusCode(200);
		given().relaxedHTTPSValidation("TLS").when().get("http://services.groupkt.com/country/get/iso3code/ita").
		then().statusCode(200);
	}
}
