import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class TestClass {

	@Test
	public void myAddTest() {

		JsonPath json = new JsonPath(Payload.coursesExample);

		int purchaseAmount = json.getInt("dashboard.purchaseAmount");

		int result = 0;

		for (int i = 0; i < json.getInt("courses.size()"); i++) {
			result += json.getInt("courses[" + i + "].price") * json.getInt("courses[" + i + "].copies");

		}

		Assert.assertEquals(purchaseAmount, result);
	}

}
