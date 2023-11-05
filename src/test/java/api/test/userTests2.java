package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class userTests2 {	
	static int id;
	
	Faker dummyData;
	User userPayload;
	
	public Logger logger;
	
	@BeforeTest
	public void setUpData() {
		dummyData = new Faker();
		userPayload = new User();
		
		userPayload.setName(dummyData.name().fullName());
		userPayload.setEmail(dummyData.internet().emailAddress());
		userPayload.setStatus("active");
		userPayload.setGender("Male");
		
//		Generating logs
		
		logger = LogManager.getLogger(this.getClass());
		

	}
	
	@Test(priority=1)
	public void testCreateUser() {
		
		logger.info("***********Creating User***********");
		
		Response res = UserEndpoints2.createUser(userPayload);
		res.then().log().body();
		id = res.jsonPath().getInt("id");
		System.out.println(id);
		
//		Assertions
		Assert.assertEquals(res.getStatusCode(), 201);
		
		logger.info("***********User is created***********");
		
	}
	
	
	
    @Test(priority=2)
	public void testGetUserByID() {
		logger.info("***********User is getting***********");

		Response res = UserEndpoints2.readUser(id);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("email"), userPayload.getEmail());
	    Assert.assertEquals(res.jsonPath().getString("name"), userPayload.getName());
	    Assert.assertEquals(res.jsonPath().getString("gender"), "male");
	    Assert.assertEquals(res.jsonPath().getString("status"), "active");
	}
	
	    
    
   @Test(priority=3)
   	public void testUpdateUser() {
	   
		logger.info("***********Updating User***********");

	   
//	   update payload data
	   userPayload.setName(dummyData.name().fullName());
	   userPayload.setEmail(dummyData.internet().emailAddress());
	   userPayload.setGender("female");
		
//	   paasing the payload
	   Response res = UserEndpoints2.updateUser(id, userPayload);
	   res.then().log().body();
	   
//		Assertions
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("email"), userPayload.getEmail());
	    Assert.assertEquals(res.jsonPath().getString("name"), userPayload.getName());
	    Assert.assertEquals(res.jsonPath().getString("gender"), "female");
		
   }
   
   
   @Test(priority = 4)
   public void testDeleteUser() {
		logger.info("***********Updating Deleted***********");

	   Response res = UserEndpoints2.deleteUser(id);
	   Assert.assertEquals(res.getStatusCode(), 204);

   }
   
   @Test(priority=5)
	public void testGetUserAfterDelete() {
		logger.info("***********Getting Deleted User***********");

		Response res = UserEndpoints2.readUser(id);
		res.then().log().body();
		
		Assert.assertEquals(res.getStatusCode(), 404);
		
	}
	
}
