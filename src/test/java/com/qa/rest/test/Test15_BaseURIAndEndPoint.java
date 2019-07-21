package com.qa.rest.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.*;

import io.restassured.RestAssured;

public class Test15_BaseURIAndEndPoint {
	
	@BeforeClass
	public void setupBaseURI() {
		RestAssured.baseURI = "http://services.groupkt.com";
		RestAssured.basePath = "/country";
		RestAssured.port = 8080;
		RestAssured.authentication = basic("username","password");
	//		RestAssured.rootPath = "x.y.z";
	//		RestAssured.filters(..) ;
	//		RestAssured.requestSpecification = ;
	//	RestAssured.responseSpecification = ;
	//	RestAssured.reset();
	}
	
	@Test
	public void test1() {
		given().get("/search?text=united").
		then().statusCode(200).log().all();
	}

	
	@Test
	public void test2() {
		given().get("/get/all").
		then().statusCode(200).log().headers();
	}

}
