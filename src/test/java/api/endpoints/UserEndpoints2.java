package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;


// users.endpoints if for creating, retrive, update and delete requests for the user API

public class UserEndpoints2 {
	
//	getting url from properties file
	public static ResourceBundle getURL(){
		 ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

//	Token
	static String bearerToken = "9aebc6032ef4db33207a9eaeb190dbd49c4e905566347d27151666bd7dd7a25b";
	
//	create user endpoint
	public static Response createUser(User payload){
		
		String url = getURL().getString("post_url");
		
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(payload)
		.when()
			.post(url);
		
		return res;
	}
	
	
//	getUser endpoint
	public static Response readUser(int id)
	{
		String url = getURL().getString("get_url");

		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.get(url);
		
		return res;
	}
	
	
	
//	update user endpoint
	public static Response updateUser(int id, User payload)
	{
		String url = getURL().getString("update_url");

		
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(payload)
			.pathParam("id", id)
		.when()
			.put(url);
		
		return res;
		
	}
	
	
//	deleteuser request endpoint
	public static Response deleteUser(int id){
		String url = getURL().getString("delete_url");

		
		Response res = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete(url);
		
		return res;
	}

}
