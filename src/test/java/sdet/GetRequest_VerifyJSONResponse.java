package sdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_VerifyJSONResponse {
	
	@Test
	public void validateJsonResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Delhi");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body : " + responseBody);

		Assert.assertEquals(responseBody.contains("Delhi"),true);

		JsonPath jsonPath = response.jsonPath();
		Assert.assertEquals(jsonPath.get("City"), "Delhi");
		
	}
}
