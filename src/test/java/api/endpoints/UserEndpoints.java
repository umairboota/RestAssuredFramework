package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.response.Response;


// users.endpoints if for creating, retrive, update and delete requests for the user API

public class UserEndpoints {
	
	static String bearerToken = "9aebc6032ef4db33207a9eaeb190dbd49c4e905566347d27151666bd7dd7a25b";
	
//	create user endpoint
	public static Response createUser(User payload){
		
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return res;
	}
	
	
//	getUser endpoint
	public static Response readUser(int id)
	{
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.get(Routes.get_url);
		
		return res;
	}
	
	
	
//	update user endpoint
	public static Response updateUser(int id, User payload)
	{
		
		Response res = given()
				.headers("Authorization", "Bearer "+bearerToken)
				.contentType("application/json")
				.body(payload)
				.pathParam("id", id)
		.when()
			.put(Routes.update_url);
		
		return res;
		
	}
	
	
//	deleteuser request endpoint
	public static Response deleteUser(int id){
		
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete(Routes.delete_url);
		
		return res;
	}

}
