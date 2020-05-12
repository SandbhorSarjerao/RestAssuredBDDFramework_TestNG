package dataDrivenTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest_AddNewEmployee_JSONObject {
	
	@Test
	public void addNewEmployee() {
		
		// Define BaseURI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
	
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "xyz");
		requestParams.put("salary", "650000");
		requestParams.put("age", "35");
		
		// Response Body
		httpRequest.body(requestParams.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST,"/create");
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("xyz"),true);
		Assert.assertEquals(responseBody.contains("650000"),true);
		Assert.assertEquals(responseBody.contains("35"),true);
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	
}
