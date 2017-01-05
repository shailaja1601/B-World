package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;



public interface CategoryDAO {
	//CRUD operations
  public boolean saveOrUpdate(Category category);
  public boolean update(Category category);
  public boolean delete(String categoryName);
  public Category get(String categoryId);
  public List<Category> list();
  public Category getByName(String name);
 
}
