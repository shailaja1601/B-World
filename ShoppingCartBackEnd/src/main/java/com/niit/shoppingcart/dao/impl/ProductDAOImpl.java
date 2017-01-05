package com.niit.shoppingcart.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	  SessionFactory sessionFactory;
	   public ProductDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	   @Transactional
	public boolean saveOrUpdate(Product product) {
		try{/*
			if(get(product.getId())!=null){
				return false;
			}
			product=(Product) sessionFactory.getCurrentSession().merge(product);
*/			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	   @Transactional
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(HibernateException e){
	      e.printStackTrace();		
		return false;
		}
	}
	   @Transactional
	public boolean delete(String productId) {
		   Product ProductToDelete=new Product();
		   ProductToDelete.setProductId(productId);;
		try{
		sessionFactory.getCurrentSession().delete(ProductToDelete);
				return true;
				}
		
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	   	 
		
		
		@Transactional  
	public Product get(String productName) {
		 String hql="from Product where productName= " + "'" + productName + "'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
	   	 @SuppressWarnings("unchecked")
		List<Product> listProduct=(List<Product>)query.list();
	   	 if(listProduct!=null && !listProduct.isEmpty()){
	   		 return listProduct.get(0);
	   	 }
		return null;
	}
	 
	 
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> list() {
		String hql="from Product";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return  query.list();
		}
	 
	
	@Transactional
	 public Product getByName(String name) {
	 	String h_query="from Product where productName= " + "'" + name +"'";
	 	Query query=sessionFactory.getCurrentSession().createQuery(h_query);
	 	
	 	return (Product)query.uniqueResult();
	 }
	
	@Transactional
	public List<Product> arrivalsList() {
		String hql="from Product order by DATE_ADDED desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setMaxResults(3);
		return  query.list();
	}

}
