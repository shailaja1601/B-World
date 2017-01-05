package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Authors;

public interface AuthorsDAO {
	
	//CRUD operations
	  public boolean saveOrUpdate(Authors authors);
	  public boolean update(Authors authors);
	  public boolean delete(String name);
	  public Authors get(String id);
	  public List<Authors> list();
	  public Authors getByName(String name);

}
