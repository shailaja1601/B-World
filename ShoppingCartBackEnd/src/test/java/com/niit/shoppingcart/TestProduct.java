package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestProduct {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Product product;
	
	@Autowired
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		productDAO= (ProductDAO) context.getBean("productDAO");
		product=(Product) context.getBean("product");
		System.out.println("BEAN CREATED");
	}
	
	//Starting of JUnit Test Cases
		//@Test
		public void createProductTestCase()
		{
			
			//product.setId("PRODUCT_04");
			//product.setPrice("325");
			//product.setName("a");
			//product.setCategoryId("Mob_01");
			
			Boolean status=productDAO.saveOrUpdate(product);
			Assert.assertEquals("Create Product Test Case",true,status);
		}
	// @Test
	  public void deleteProductTestCase()
	{
		 // product.setId("Mob_05");
		  Boolean status=productDAO.delete(" ");
		  Assert.assertEquals("Delete Product Test Case",true,status);
		}
	@Test
	  public void updateProductTestCase(){
		 product.setProductId("Product_04");
		 product.setProductName("Unbroken");
		 product.setPrice(300);
		 product.setAuthorID("Author_02");
		 product.setCategoryID("category_01");
		 product.setLanguageID("L-02");
		 product.setSupplierID("supplier_01");
		 product.setDescription("vnhvgjfrhngifrgit");
		 product.setStock(20);
		  Boolean status=productDAO.update(product);
		  Assert.assertEquals("update Product Test Case",true,status);
	  }
	// @Test
	  public void getProductTestCase()
	  {
		  Assert.assertEquals("Get Product Test Case",null,productDAO.get("Mob_01"));  
	  }
	 // @Test
	  public void getAllProductTestCase()
	  {
		  Assert.assertEquals("Get Product Test Case",3,productDAO.list().size());
	  }

}
