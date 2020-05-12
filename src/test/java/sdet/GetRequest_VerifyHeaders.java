package sdet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_VerifyHeaders {

	@Test
	public void getAllHeaders() {
		RestAssured.baseURI = "";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body" + responseBody);
		
		Headers allHeaders = response.headers();
		
		for(Header h : allHeaders)
		{
			System.out.println(h.getName() + " : " + h.getValue());
		}
	}
}
