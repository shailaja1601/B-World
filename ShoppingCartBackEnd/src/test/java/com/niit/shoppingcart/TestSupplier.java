package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class TestSupplier {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Supplier supplier;
	
	@Autowired
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		supplierDAO= (SupplierDAO) context.getBean("supplierDAO");
		supplier=(Supplier) context.getBean("supplier");
		System.out.println("Supplier's BEAN CREATED");
	}
	//Starting of JUnit Test Cases
		@Test
		public void createSupplierTestCase()
		{
			
			supplier.setId("Mob_01");
			supplier.setAddress("This is a");
			supplier.setName("abc");
			
			Boolean status=supplierDAO.saveOrUpdate(supplier);
			Assert.assertEquals("Create Supplier Test Case",true,status);
		}
	// @Test
	  public void deleteSupplierTestCase()
	{
		  supplier.setId("Mob_05");
		  Boolean status=supplierDAO.delete(" ");
		  Assert.assertEquals("Delete Supplier Test Case",true,status);
		}
	// @Test
	  public void updateSupplierTestCase(){
		  supplier.setId("Mob_03");
		  supplier.setAddress("This is Mob_03");
		  Boolean status=supplierDAO.update(supplier);
		  Assert.assertEquals("update Supplier Test Case",true,status);
	  }
	// @Test
	  public void getSupplierTestCase()
	  {
		  Assert.assertEquals("Get Supplier Test Case",null,supplierDAO.get("Mob_01"));  
	  }
	  //@Test
	  public void getAllSupplierTestCase()
	  {
		  Assert.assertEquals("Get Supplier Test Case",3,supplierDAO.list().size());
	  }
	}



