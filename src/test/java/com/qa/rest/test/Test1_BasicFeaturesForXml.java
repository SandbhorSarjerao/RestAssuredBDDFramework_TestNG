package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.xml.HasXPath.*;

import io.restassured.response.*;
import io.restassured.http.*;


public class Test1_BasicFeaturesForXml {
	
	// *** 1.Checking Status Code  ***
	@Test
	public void testStatusCode() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.statusCode(200);		
	}

	// *** 2.Verify Status Code & Print complete Response in Console ***
	@Test
	public void testLogging() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.statusCode(200)
			.log().all();
	}
	
	// *** 3.To test xml response for Single Content using 'org.hamcrest.Matchers' library's equalTo() method ***
	@Test
	public void testSingleContent() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.body("CUSTOMER.ID", equalTo("10"))
			.log().all();
	}

	// *** 4.To test xml response for Multiple body Content using 'org.hamcrest.Matchers' library's equalTo() method ***
	@Test
	public void testMultipleContent() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.body("CUSTOMER.ID", equalTo("10"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
			.body("CUSTOMER.LASTNAME", equalTo("Fuller"))
			.body("CUSTOMER.STREET", equalTo("135 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Dallas"));
	}
		
	// *** 5.To test xml response complete text using 'org.hamcrest.Matchers' library's equalTo() method ***
	@Test
	public void testCompleteText() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"))
			.log().all();
	}


	// *** 6.To test xml response using 'hasXPath()' method ***
	@Test
	public void testByXPathMethod() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
		then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='40']"));
	}
	
	
	// *** 7.To test xml response using 'hasXPath()' and 'containsString()' method ***
	@Test
	public void testByXPathAndContainsStringMethod() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		then()
			.body(hasXPath("CUSTOMER/FIRSTNAME", containsString("Sue")));
	}
}













