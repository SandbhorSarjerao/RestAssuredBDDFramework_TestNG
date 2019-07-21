package com.qa.rest.test;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import io.restassured.response.*;
import io.restassured.http.*;


public class Test2_SettingRoot {
	
	// *** 1.Basic way to test all parameters ***
	@Test
	public void testWithoutRoot() {
		given()
			.get("http://services.groupkt.com/country/get/iso3code/ita").
		then()
			.body("RestResponse.result.name", is("Italy"))
			.body("RestResponse.result.alpha2_code", is("IT"))
			.body("RestResponse.result.alpha3_code", is("ITA"));
	}

	// *** 2.Recommended way to test all parameters using 'root' feature ***
	@Test
	public void testWithRoot() {
		given()
			.get("http://services.groupkt.com/country/get/iso3code/ita").
		then()
			.root("RestResponse.result")
			.body("name", is("Italy"))
			.body("alpha2_code", is("IT"))
			.body("alpha3_code", is("ITA"));
	}

	// *** 3.We can detach 'root' path in between ***
	@Test
	public void testDetachRoot() {
		given()
			.get("http://services.groupkt.com/country/get/iso3code/ita").
		then()
			.root("RestResponse.result")
			.body("name", is("Italy"))
			.body("alpha2_code", is("IT"))
			.detachRoot("result")
			.body("result.alpha3_code", is("ITA"));
	}
}
