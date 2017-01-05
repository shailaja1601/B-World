package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {
	//CRUD operations
	  public boolean saveOrUpdate(Supplier supplier);
	 public boolean update(Supplier supplier);
	  public boolean delete(String id);
	  public Supplier get(String id);
	  public List<Supplier> list();
	  public Supplier getByName(String name);

}
