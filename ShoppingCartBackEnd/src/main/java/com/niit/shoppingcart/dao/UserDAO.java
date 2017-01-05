package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {
	//CRUD operations
	  public boolean saveOrUpdate(User user);
	  public boolean update(User user);
	 // public boolean delete(User user);
	  public User get(String mailID);
	  public List<User> list();
	  public User isValidUser(String userMailID, String password);
	  
}
