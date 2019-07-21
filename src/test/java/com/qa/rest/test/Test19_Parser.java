package com.qa.rest.test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Test19_Parser {
	
	@Test
	public void testDefaultParser() {
		// Anyone can be used
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.defaultParser = Parser.XML;
		RestAssured.defaultParser = Parser.HTML;
		RestAssured.defaultParser = Parser.TEXT;
	}
	
	@Test
	public void testDefaultParser2() {
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").
		then()
			.using()
			.defaultParser(Parser.JSON);
		
		given()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/").
		then()
			.using()
			.defaultParser(Parser.XML);
	}
	
	@Test
	public void testCustomParser1() {
		RestAssured.registerParser("application/vnd.uoml+xml", Parser.XML);
		RestAssured.unregisterParser("application/vnd.uoml+xml");
	}
	
	@Test
	public void testCustomParser2() {
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02/"). 
		then()
			.using()
			.parser("application/vnd.uoml+xml", Parser.XML);
	}
}
