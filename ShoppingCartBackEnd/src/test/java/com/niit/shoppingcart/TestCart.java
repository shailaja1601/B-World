package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


public class TestCart {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Cart cart;
	
	@Autowired
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		cartDAO= (CartDAO) context.getBean("cartDAO");
		cart=(Cart) context.getBean("cart");
		System.out.println("cart BEAN CREATED");
	}
	
	//Starting of JUnit Test Cases
		@Test
		public void createCartTestCase()
		{
			/*
			cart.setId("CART_04");
			cart.setName("PRODUCT_02");
			cart.setQuantity("2");
			cart.setPrice("1000");
			*/
			Boolean status=cartDAO.save(cart);
			Assert.assertEquals("Create Cart Test Case",true,status);
		}
	 @Test
	 public void deleteCartTestCase()
	{
		 // cart.setId("CART_01");
		 
		  Boolean status=cartDAO.delete(cart);
		  Assert.assertEquals("Delete cart Test Case",true,status);
		}
	@Test
	  public void updateCartTestCase(){
		  /*cart.setId("CART_01");
		  cart.setQuantity("3");
		  cart.setPrice("1000");
		  */
		  Boolean status=cartDAO.update(cart);
		  Assert.assertEquals("update cart Test Case",true,status);
	  }
	 @Test
	  public void getCartTestCase()
	  {
		  Assert.assertEquals("Get Cart Test Case",null,cartDAO.get("Cart_02"));  
	  }
	  @Test
	  public void getAllProductTestCase()
	  {
		  String username = null;
		Assert.assertEquals("Get Cart Test Case",3,cartDAO.list(username).size());
	  }

}
