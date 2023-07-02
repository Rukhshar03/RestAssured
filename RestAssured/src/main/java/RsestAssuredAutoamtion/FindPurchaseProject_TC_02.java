package RsestAssuredAutoamtion;

import java.io.File;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class FindPurchaseProject_TC_02 {
	
	@Test
	public void sampleRestAssured() throws FileNotFoundException{
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order";
		
	    ExtractableResponse<Response> response =RestAssured.given().log().all().contentType("application/json").header("Key","special-key").pathParam("orderId ","1").when().
	    		get().then().log().all().extract();
	     
	     int statusCode = response.statusCode();
	     Assert.assertEquals(statusCode,200);
	     System.out.println(response.body());
		
		
	}

}
