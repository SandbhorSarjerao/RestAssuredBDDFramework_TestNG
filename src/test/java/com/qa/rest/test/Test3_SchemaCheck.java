package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.TypeSafeMatcher.*;

import java.io.IOException;
import java.io.InputStream;

import io.restassured.response.*;
import io.restassured.http.*;

public class Test3_SchemaCheck {

	// *** 1.To verify the response type  ***
	@Test
	public void testContentType() {
		
		given()
			.get("http://services.groupkt.com/country/get/iso2code/cn").
		then()
			.statusCode(200)
			.contentType(ContentType.JSON);
		//	.contentType(ContentType.XML);
		//	.contentType(ContentType.HTML);
	}

	// *** 2.To verify the response Schema with the expected Schema File (Path=> "src/test/resources/geo-schema.json") ***
	@Test
	public void testSchema() {
		given()
			.get("http://geo.groupkt.com/ip/172.4.14/json").
		then()
			.assertThat().body(matchesJsonSchemaInClasspath("src/test/resources/geo-schema.json"));
	}
}
