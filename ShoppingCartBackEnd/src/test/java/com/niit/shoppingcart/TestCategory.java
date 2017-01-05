package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;


public class TestCategory {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Category category;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		category=(Category) context.getBean("category");
		System.out.println("BEAN CREATED");
	}
	//Starting of JUnit Test Cases
	//@Test
	public void createCategoryTestCase()
	{
		
		category.setId("Mob_01");
		category.setDescription("This is a");
		category.setName("abc");
		
		Boolean status=categoryDAO.saveOrUpdate(category);
		Assert.assertEquals("Create Category Test Case",true,status);
	}
 @Test
  public void deleteCategoryTestCase()
{
	  category.setId("Mob_06");
	  Boolean status=categoryDAO.delete("Mob_06");
	  Assert.assertEquals("Delete Category Test Case",true,status);
	}
 /*@Test
  public void updateCategoryTestCase(){
	  category.setId("Mob_03");
	  category.setDescription("This is Mob_03");
	  Boolean status=categoryDAO.update(category);
	  Assert.assertEquals("update Category Test Case",true,status);
  }*/
 @Test
  public void getCategoryTestCase()
  {
	  Assert.assertEquals("Get Category Test Case",null,categoryDAO.get("Mob_01"));  
  }
  @Test
  public void getAllCategoryTestCase()
  {
	  Assert.assertEquals("Get Category Test Case",3,categoryDAO.list().size());
  }
}
