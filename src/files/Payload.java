package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class Payload {

	static String defaultPayload = "{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n"
			+ "    \"lng\": 33.427362\n" + "  },\n" + "  \"accuracy\": 50,\n" + "  \"name\": \"Frontline house\",\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \"29, side layout, cohen 09\",\n"
			+ "  \"types\": [\n" + "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
			+ "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}";

	static String updatePlaceDefault = "{\n" + "\"place_id\":\"RRRR\",\n" + "\"address\":\"ZZZZ\",\n"
			+ "\"key\":\"qaclick123\"\n" + "}";

	public static String coursesExample = "{\n" + "\n" + "\"dashboard\": {\n" + "\n" + "\"purchaseAmount\": 910,\n"
			+ "\n" + "\"website\": \"rahulshettyacademy.com\"\n" + "\n" + "},\n" + "\n" + "\"courses\": [\n" + "\n"
			+ "{\n" + "\n" + "\"title\": \"Selenium Python\",\n" + "\n" + "\"price\": 50,\n" + "\n" + "\"copies\": 6\n"
			+ "\n" + "},\n" + "\n" + "{\n" + "\n" + "\"title\": \"Cypress\",\n" + "\n" + "\"price\": 40,\n" + "\n"
			+ "\"copies\": 4\n" + "\n" + "},\n" + "\n" + "{\n" + "\n" + "\"title\": \"RPA\",\n" + "\n"
			+ "\"price\": 45,\n" + "\n" + "\"copies\": 10\n" + "\n" + "}\n" + "\n" + "]\n" + "\n" + "}";

	public static String addPlace() {
		return defaultPayload;
	}

	public static String updatePlace(String placeId, String newAddress) {
		return updatePlaceDefault.replace("RRRR", placeId).replace("ZZZZ", newAddress);
	}

	public static JsonPath rawToJson(String data) {
		return new JsonPath(data);
	}

	public static String addBook(String isbn, String aisle) {
		return "{\n" + "\n" + "\"name\":\"Learn Appium Automation with Java\",\n" + "\"isbn\":\"" + isbn + "\",\n"
				+ "\"aisle\":\"" + aisle + "\",\n" + "\"author\":\"John foe\"\n" + "}";
	}

	public static String GenerateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

}
