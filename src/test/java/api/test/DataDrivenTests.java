//package api.test;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import api.endpoints.UserEndpoints;
//import api.payload.User;
//import api.utilities.DataProviders;
//import io.restassured.response.Response;
//
//public class DataDrivenTests {
//	
////	static variable
//	
//	static int id;
//	
//	
//	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
//	public void testPostUser(String name, String email, String gender, String status) {
//		
//		User userPayload = new User();
//		
//		userPayload.setName(name);
//		userPayload.setEmail(email);
//		userPayload.setGender(gender);
//		userPayload.setStatus(status);
//		
//		Response res = UserEndpoints.createUser(userPayload);
//		id = res.jsonPath().getInt("id");
//		System.out.println(id);
//		
//			
////		Assertions
//		Assert.assertEquals(res.getStatusCode(), 201);
//		
//	}
//	
//	@Test(priority = 2, dataProvider = "UserID", dataProviderClass = DataProviders.class)
//	public void testDeleteUser(int id) {
//	    Response res = UserEndpoints.deleteUser(id);
//	    Assert.assertEquals(res.getStatusCode(), 204);
//	}
//	
//
//}
