package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.AuthorsDAO;
import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

@Repository("authorsDAO")
public class AuthorsDAOImpl implements AuthorsDAO {
	
	@Autowired
	  SessionFactory sessionFactory;
		
	   public AuthorsDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
    @Transactional
	public boolean saveOrUpdate(Authors authors) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(authors);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
    
    @Transactional
  	public boolean update(Authors authors) {
  		try{
  			if(get(authors.getAuthorsId())==null){
  				return false;
  			}
  			authors=(Authors) sessionFactory.getCurrentSession().merge(authors);
  			sessionFactory.getCurrentSession().update(authors);
  			
  			return true;
  		}
  		catch(HibernateException e){
  	      e.printStackTrace();		
  		return false;
  		}
    }
    
    @Transactional
	public boolean delete(String author) {
    	Authors AuthorsToDelete=new Authors();
    	AuthorsToDelete.setAuthor(author);
 	try{
 		sessionFactory.getCurrentSession().delete(AuthorsToDelete);
		return true;
		}
	catch(Exception e)
	{
		e.printStackTrace();
	return false;
		}
}
   
    @Transactional
	public Authors get(String id) {
		 String hql="from Authors where authorsId="+"'"+ id +"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("unchecked")
		List<Authors> listAuthors=(List<Authors>)query.list();
		 if(listAuthors!=null && !listAuthors.isEmpty()){
			 return listAuthors.get(0);
		 }
		 return null;
	}
    
    @SuppressWarnings("unchecked")
	@Transactional
	public List<Authors> list() {
    	String hql="from Authors";
    	Query query=sessionFactory.getCurrentSession().createQuery(hql);
    	return  query.list();
	}
	
    @Transactional
    public Authors getByName(String name) {
    	String h_query="from Authors where author= " + "'" + name +"'";
    	Query query=sessionFactory.getCurrentSession().createQuery(h_query);
    	return (Authors)query.uniqueResult();
    }

}
