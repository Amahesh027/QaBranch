package com.qa.curdoperation.test;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CrudOperations {

	Logger logger = Logger.getLogger(CrudOperations.class);

	@Test
	public void getProductDetails() throws JSONException {
		Response resp = RestAssured.get("http://localhost:9005/products");
		int stausCode = resp.getStatusCode();
		JSONArray jsonResponse = new JSONArray(resp.asString());
		logger.info("Responce Body ----->" + jsonResponse);
		System.out.println("Responce Body ----->" + jsonResponse);
		String Fname = jsonResponse.getJSONObject(0).getString("name");
		String Lname = jsonResponse.getJSONObject(1).getString("name");
		Assert.assertEquals(stausCode, 200);
	/*	Assert.assertEquals(Fname, "Honey");
		Assert.assertEquals(Lname, "Almond");*/

		
	/*	 * String json = resp.getBody().asString(); System.out.println(json);
		 * 
		 * // Use the JsonPath parsing library of RestAssured to Parse the JSON
		 * 
		 * JsonPath jsonPath = new JsonPath(json); Assert.assertEquals( "Honey",
		 * jsonPath.getString("name"));
		 */

	}

/*	@Test
	public void createProductDetails() throws JSONException {

		// Post method

		RestAssured.baseURI = "http://localhost:9005/products";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", "2"); // Cast
		requestParams.put("name", "Mangao");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		System.out.println("Request "+requestParams.toString());
		Response response = request.post("");
		logger.info("POST Responce Body ----->" + response.asString());
		System.out.println("POST Responce Body ----->" + response.asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);

	}

	@Test
	public void updateProductDetails() throws JSONException {

		RestAssured.baseURI = "http://localhost:9005/products";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "apple");
		request.header("Content-Type", "application/json");
		request.body(requestParams.toString());
		Response response = request.put("/3");
		logger.info("Update Responce Body ----->" + response.asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void deleteProductDetails() throws JSONException {

		RestAssured.baseURI = "http://localhost:9005/products";
		RequestSpecification request = RestAssured.given();
		// JSONObject requestParams = new JSONObject();
		Response response = request.delete("/4");
		logger.info("DELETE Responce Body ----->" + response.asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}*/

	@Test
	public void getProductDetailsWithBasicAuthentication() throws JSONException {
		Response resp = RestAssured.given().auth().basic("ToolsQA", "TestPassword").when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication");
		System.out.println("" + resp.toString());
		int stausCode = resp.getStatusCode();
		System.out.println("" + stausCode);
		if ("200".equalsIgnoreCase(String.valueOf(stausCode))) {
			System.out.println("AUTHENTICATION  SUCCESSFUL");
		} else {
			System.out.println("AUTHENTICATION NOT SUCCESSFUL");

		}

	}

}
	