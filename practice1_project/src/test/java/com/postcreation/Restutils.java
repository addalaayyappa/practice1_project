package com.postcreation;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restutils {
	@Test
	public static  Response executepost(Map requestbody,String url) {
RequestSpecification rsp =		RestAssured.given().contentType("application/json");
		
		rsp.body(requestbody);
	return	rsp.post(url);
	}
	

	

}
