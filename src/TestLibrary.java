import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import files.Payload;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

public class TestLibrary {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle)

	{

		RestAssured.baseURI = "http://216.10.245.166";

		String resp = given().

				header("Content-Type", "application/json").

				body(Payload.addBook(isbn, aisle)).

				when().

				post("/Library/Addbook.php").

				then().assertThat().statusCode(200).

				extract().response().asString();

		JsonPath js = Payload.rawToJson(resp);

		String id = js.get("ID");

		System.out.println(id);

		// deleteBOok

	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object[][] { { "red", "9363" }, { "blue", "4253" }, { "white", "533" } };
	}

}