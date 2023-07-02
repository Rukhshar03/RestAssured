package RsestAssuredAutoamtion;
import java.io.FileNotFoundException;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class PlaceOrder_TC_01 {

	@Test
	public void sampleRestAssured() throws FileNotFoundException{
		
		File file = new File("./src/main/java/Data/placeOrder.json");
		
		System.out.println(file);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order";
		
	    ExtractableResponse<Response> response =	RestAssured.given().log().all().contentType("application/json").header("Key","special-key").body(file).when().
	    		post().then().log().all().extract();
	     
	     int statusCode = response.statusCode();
	     Assert.assertEquals(statusCode,200);
	     System.out.println(response.body());
		
		
	}
}
