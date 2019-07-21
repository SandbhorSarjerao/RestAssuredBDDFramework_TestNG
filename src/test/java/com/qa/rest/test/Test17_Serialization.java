package com.qa.rest.test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;

public class Test17_Serialization {
	
	@Test
	public void testSerializationUsingHashMap() {
		
		Map<String, String> inputJson = new HashMap<>();
		inputJson.put("firstName", "Abc");
		inputJson.put("lastName", "Pqr");
		inputJson.put("Age", "30");
		
		given()
			.contentType("application/json")
			.body(inputJson).
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200);
	}
	
	@Test
	public void testSerializationUsingContentType() {
		
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(10);
		obj.setWeight(100);
		obj.setHome("India");
		
		given()
			.contentType("application/json")
			.body(obj).
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200)
			.contentType("application/xml").log().all();
	}

	@Test
	public void testSerializationUsingExplicitSerilizer() {
		
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(1);
		obj.setWeight(10);
		obj.setHome("Canada");
		
		given()
			//.contentType("application/json")
			.body(obj,ObjectMapperType.JACKSON_2).
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200)
			.contentType("application/xml").log().all();
	}
}
