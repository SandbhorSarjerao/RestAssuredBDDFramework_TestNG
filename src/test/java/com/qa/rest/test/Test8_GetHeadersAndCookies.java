package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Test8_GetHeadersAndCookies {

	// *** 1.Get Response Headers ***
	@Test
	public void testResponseHeaders() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");

		// To get Single Header
		String headerCFRAY = response.getHeader("CF-RAY");
		System.out.println("======>>> Header <<<======"+ headerCFRAY);
		System.out.println("");
			
		// To get All Headers
		Headers headers = response.getHeaders();
		for(Header h : headers)
		{
			System.out.println(h.getName() + " : " + h.getValue());
		}
	}
		
	// *** 2. To Get Cookies ***
	@Test
	public void testCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();
			
		for(Map.Entry<String, String> entry : cookies.entrySet())
			{
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
	// *** 3. To Get Detailed Cookies ***
	@Test
	public void testDetailedCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
			
		Cookie a = response.getDetailedCookie("__cfduid");
		System.out.println(" *** Detailed: " + a.hasExpiryDate());
		System.out.println(" *** Detailed: " + a.getExpiryDate());
		System.out.println(" *** Detailed: " + a.hasValue());
	}	
}
