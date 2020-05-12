package dataDrivenTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest_AddNewEmployee_DataProvider {
	
	@Test(dataProvider="empDataProvider")
	public void addNewEmployee(String eName, String eSal, String eAge) {
		
		// Define BaseURI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
	
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", eName);
		requestParams.put("salary", eSal);
		requestParams.put("age", eAge);
		
		// Response Body
		httpRequest.body(requestParams.toJSONString());
		
		// Response Object
		Response response = httpRequest.request(Method.POST,"/create");
		
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(eName),true);
		Assert.assertEquals(responseBody.contains(eSal),true);
		Assert.assertEquals(responseBody.contains(eAge),true);
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@DataProvider(name="empDataProvider")
	String [][] getEmployeeData() {
		String empData[][] = {{"abc","70000","38"},{"pqr","75000","39"},{"xyz","80000","39"}};
		return empData;
	}
}
