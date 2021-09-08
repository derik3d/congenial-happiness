import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;

public class MainClass {
	public static void main(String... strings) {

		System.out.println("daniela es una re chimba");

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().log().all().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)")
				.extract().response().asString();

		System.out.println(response);

		JsonPath jsonData = new JsonPath(response);
		String placeId = jsonData.getString("place_id");
		System.out.println(placeId);

		String newAddress = "123 false street";

		// update place

		given().log().all().header("Content-Type", "application/json").body(Payload.updatePlace(placeId, newAddress))
				.when().log().all().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// get place

		String responseGet = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.header("Content-Type", "application/json").when().log().all().get("maps/api/place/get/json").then()
				.log().all().statusCode(200).assertThat().body("address", equalTo(newAddress)).extract().response()
				.asString();

		JsonPath jsonDataGet = new JsonPath(responseGet);
		String newGetAddress = jsonDataGet.getString("address");
		System.out.println(newGetAddress);

		Assert.assertEquals(newAddress, newGetAddress);

	}

}
