package com.postcreation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.apache.http.util.Asserts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.config.ObjectMapperConfig;
import io.restassured.response.Response;

public class postexecute {
	@Test(dataProvider = "airlinedata")
	public void Airline(String file,int statuscode) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	Map reqbody = 	mapper.readValue(Paths.get(file).toFile(), Map.class);
reqbody.put("id", RandomUtils.nextInt());

 Response resp =   Restutils.executepost(reqbody,Airline_endploints.postAirline);
	  System.out.println( resp.body().asPrettyString());
	  System.out.println(resp.getStatusCode());
	 System.out.println(  resp.getHeaders());
	  

	}
	@DataProvider
	 public Object[][] airlinedata() {
		Object [][] data =new Object[1][2];
		data[0][0]="src/test/resources/Airlinepayload/data.json";
		data[0][1]=200;
		
		return data;
	}

}
