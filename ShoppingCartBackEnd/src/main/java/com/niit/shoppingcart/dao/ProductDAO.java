package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
	//CRUD operations
	  public boolean saveOrUpdate(Product product);
	  public boolean update(Product product);
	  public boolean delete(String productId);
	  public Product get(String productName);
	  public List<Product> list();
	  public List<Product> arrivalsList();

}
