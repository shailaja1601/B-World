package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;


public class TestUser {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		userDAO= (UserDAO) context.getBean("userDAO");
		user=(User) context.getBean("user");
		System.out.println("User's BEAN CREATED");
	}
	//Starting of JUnit Test Cases
		@Test
		public void createUserTestCase()
		{
			
			//user.setId("06");
			user.setName("user123");
			user.setPassword("user123");
			user.setContact("12900012");
			user.setMail("user@abc.com");
			user.setRole("User");
			Boolean status=userDAO.saveOrUpdate(user);
			Assert.assertEquals("Create User Test Case",true,status);
		}
	// @Test
	  public void deleteUserTestCase()
	{
		 // user.setId("User_04");
		 // Boolean status=userDAO.delete(user);
		 // Assert.assertEquals("Delete User Test Case",true,status);
		}
	// @Test
	  public void updateUserTestCase(){
		 // user.setId("Mob_01");
		  user.setContact("22558833");
		 
		  Boolean status=userDAO.update(user);
		  Assert.assertEquals("update User Test Case",true,status);
	  }
	//@Test
	  public void getUserTestCase()
	  {
		  Assert.assertEquals("Get User Test Case",null,userDAO.get("Panvel"));  
	  }
	 // @Test
	  public void getAllUserTestCase()
	  {
		  Assert.assertEquals("Get User Test Case",3,userDAO.list().size());
	  }

}
