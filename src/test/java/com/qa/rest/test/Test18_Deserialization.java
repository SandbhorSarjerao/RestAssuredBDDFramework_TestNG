package com.qa.rest.test;

import com.qa.rest.test.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;

public class Test18_Deserialization {
	
	@Test
	public void testDeserializationusingContentType() {
	ZebraRequestClassNew reqObj = new ZebraRequestClassNew();
	reqObj.setAge(5);
	reqObj.setWeight(50);
	reqObj.setHome("France");
	
	ZebraResponseClass respObj = 
			given()
				.body(reqObj).
			when()
				.post("http://www.thomas-bayer.com/restnames/countries.groovy")
				.as(ZebraResponseClass.class);
	
	respObj.setRegId(1101);
	Assert.assertTrue(respObj.getRegId() > 0);
	}
}
