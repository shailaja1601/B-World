package com.niit.shoppingcart.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
  SessionFactory sessionFactory;
	
   public CategoryDAOImpl(SessionFactory sessionFactory)
   {
	   this.sessionFactory=sessionFactory;
   }
   
   @Transactional
public boolean saveOrUpdate(Category category) {
			try{
				
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	
				return true;
	}
	catch(HibernateException e){
		e.printStackTrace();
	return false;
	}
}
   
   @Transactional
   public boolean update(Category category) {
   			try{
   				
   		sessionFactory.getCurrentSession().update(category);
   		
   	
   				return true;
   	}
   	catch(HibernateException e){
   		e.printStackTrace();
   	return false;
   	}
   }
 
   @Transactional
public boolean delete(String categoryName) {
	   Category CategoryToDelete=new Category();
	   CategoryToDelete.setCategoryName(categoryName);
	try{
		
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
			return true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
			}
			}
	
	
 
@Transactional  
public Category get(String categoryId) {
	 String hql="from Category where categoryId= "+"'"+ categoryId +"'";
	 Query query=sessionFactory.getCurrentSession().createQuery(hql);
	 @SuppressWarnings("unchecked")
	List<Category> listCategory=(List<Category>)query.list();
	 if(listCategory!=null && !listCategory.isEmpty()){
		 return listCategory.get(0);
	 }
	 return null;
}
 
 
 @SuppressWarnings("unchecked")
@Transactional
public List<Category> list() {
	 	String hql="from Category";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return  query.list();
}

 
@Transactional
public Category getByName(String name) {
	String h_query="from Category where categoryName= " + "'" + name +"'";
	Query query=sessionFactory.getCurrentSession().createQuery(h_query);
	return (Category)query.uniqueResult();
}
}
