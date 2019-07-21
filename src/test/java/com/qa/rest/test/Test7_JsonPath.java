package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.lang.String;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import io.restassured.http.*;

public class Test7_JsonPath {
	
	// *** 1.Extract details asString() and fetching further details w/o using json path ***
	@Test
	public void testJsonPath1() {
		String responseAsString = 
				when()
					.get("http://jsonplaceholder.typicode.come/photos").
				then().
				extract().asString();
		
		//	List<Integer> albumIds =  from(responseAsString).get("id");
	//	System.out.println(albumIds.size());
	}
	
	// *** 2.Extract details asString() and fetching further details using JSONPath ***
	@Test
	public void testJsonPath2() {
		String json =
				when()
					.get("http://services.groupkt.com/country/get/all").
				then().
				extract().asString();
		
		JsonPath jsonPath = new JsonPath(json).setRoot("RestResponse.result");
		
		List<String> list = jsonPath.get("name");
		System.out.println(list.size());
	}
}
