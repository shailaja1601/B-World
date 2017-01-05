package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Languages;

public interface LanguagesDAO {
	
	//CRUD operations
	  public boolean saveOrUpdate(Languages languages);
	  public boolean update(Languages languages);
	  public boolean delete(String id);
	  public Languages get(String id);
	  public List<Languages> list();
	  public Languages getByName(String name);


}
