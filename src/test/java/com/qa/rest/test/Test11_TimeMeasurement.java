package com.qa.rest.test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

public class Test11_TimeMeasurement {
	
	// *** 1. Response Time measurement ***
	// Include HTTP round trip
	// Rest Assured processing time
	@Test
	public void testResponseTime() {
		long t = given().get("http://jsonplaceholder.typicode.com/photos/").time();
		System.out.println("====>> Time(ms <<======" + t);
	}
	
	@Test
	public void testResponseTimeUnit() {
		long t = given().get("http://jsonplaceholder.typicode.com/photos/1").timeIn(TimeUnit.MICROSECONDS);
		System.out.println("====>> Time(ms <<======" + t);	
	}

	@Test
	public void testResponseTimeAsssertion() {
		given().get("http://jsonplaceholder.typicode.com/photos/").then().time(lessThan(500L));
	}

}
