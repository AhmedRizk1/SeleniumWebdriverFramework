package tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class RestAssuredAPI  {

	static String url = "https://jsonplaceholder.typicode.com/posts";

	@Test(priority = 1)
	public static void getAllPostsAPI() {
		System.out.println("...................Test Get ALL Posts API.....................");
		Response response = given().when().get(url).then().extract().response();

		int size = response.jsonPath().getList("id").size();
		System.out.println("Response Body of Get All Posts API = " + response.asString());
		System.out.println("Size of Get All Posts API = " + size);
		// Assert on Response Size
		assertEquals(size, 100);

	}

	@Test(priority = 2)
	public static void getPostByIDAPI() {
		System.out.println(".................Test  Get Post By ID API...................");
		Response response = given().queryParam("id", "35").when().get(url).then().extract().response();
		System.out.println("Response code of Get Post By ID API for (ID : 35) = " + response.getStatusCode());
		System.out.println("Response Body of Get Post By ID API for (ID : 35) = " + response.asString());
		// Assert on Status Code
		assertEquals(response.statusCode(), 200);
		// Assert on Response Body  
		assertTrue(response.asString().contains("title\": \"id nihil consequatur molestias animi provident"));
	}

	@Test(priority = 3)
	public void createPostAPI() {
		System.out.println(".......................Test  Create Post API...................");
		Response response = (Response) given().contentType("application/json")
				.body("{\r\n\t \"title\": \"foo\" \r\n , \"body\": \"bar\", \r\n  \"userId\": 1\r\n}").post(url).then()
				.extract().response();

		System.out.println("Response code of Create Post API  = " + response.getStatusCode());
		System.out.println("Response Body of Create Post API  = " + response.asString());
		// Assert on Status Code
		assertEquals(response.statusCode(), 201);
	}
}
