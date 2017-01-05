package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	  SessionFactory sessionFactory;
	   public SupplierDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	   @Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		try{
			/*if(get(supplier.getId())!=null){
				return false;
			}*/
			//supplier=(Supplier) sessionFactory.getCurrentSession().merge(supplier);
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	   @Transactional
	public boolean update(Supplier supplier) {
		try{
			if(get(supplier.getSupplierId())==null){
				return false;
			}
			supplier=(Supplier) sessionFactory.getCurrentSession().merge(supplier);
			sessionFactory.getCurrentSession().update(supplier);
			
			return true;
		}
		catch(HibernateException e){
	      e.printStackTrace();		
		return false;
		}
	}
	     @Transactional
	public boolean delete(String id) {
		   	Supplier a=new Supplier();
			a.setSupplierId(id);;
			try{
			/*a=get(supplier.getId());
			System.out.println(a.getId());
			if(get(supplier.getId())!=null){
				supplier=(Supplier) sessionFactory.getCurrentSession().merge(supplier);*/
				sessionFactory.getCurrentSession().delete(a);
				return true;
				}		
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	    
	 @Transactional  
	public Supplier get(String id) {
		 String hql="from Supplier where supplierId="+"'"+ id +"'";
     	 Query query=sessionFactory.getCurrentSession().createQuery(hql);
     	 List<Supplier> listSupplier=(List<Supplier>)query.list();
     	 if(listSupplier!=null && !listSupplier.isEmpty()){
     		 return listSupplier.get(0);
     	 }
     	 return null;

	}
	 
	 @Transactional
	public List<Supplier> list() {
		String hql="from Supplier";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return  query.list();
	}
	 
	 @Transactional
	 public Supplier getByName(String name) {
	 	String h_query="from Supplier where supplierName= " + "'" + name +"'";
	 	Query query=sessionFactory.getCurrentSession().createQuery(h_query);
	 	
	 	return (Supplier)query.uniqueResult();
	 }

}
