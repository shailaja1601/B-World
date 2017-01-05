package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.LanguagesDAO;
import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.Languages;

@Repository("languagesDAO")
public class LanguagesDAOImpl implements LanguagesDAO{
	
	@Autowired
	  SessionFactory sessionFactory;
		
	   public LanguagesDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
    
	   @Transactional
	public boolean saveOrUpdate(Languages languages) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(languages);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	   
	   @Transactional
		public boolean update(Languages languages) {
			try{
				sessionFactory.getCurrentSession().update(languages);
				return true;
			}
			catch(HibernateException e){
				e.printStackTrace();
			return false;
			}
		}
     
	   @Transactional
	public boolean delete(String id) {
		   Languages LanguagesToDelete=new Languages();
		   LanguagesToDelete.setId(id);
	 	try{
	 		sessionFactory.getCurrentSession().delete(LanguagesToDelete);
			return true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		return false;
			}
	}
    
	   @Transactional
	public Languages get(String id) {
		   String hql="from Languages where id = "+ "'" + id +"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			 @SuppressWarnings("unchecked")
			List<Languages> listLanguages=(List<Languages>)query.list();
			 if(listLanguages!=null && !listLanguages.isEmpty()){
				 return listLanguages.get(0);
			 }
			 return null;
	}
    
	   @Transactional
	public List<Languages> list() {
		   String hql="from Languages";
	    	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	    	return  query.list();
	}
	   
	   @Transactional
	    public Languages getByName(String name) {
	    	String h_query="from Languages where language= " + "'" + name +"'";
	    	Query query=sessionFactory.getCurrentSession().createQuery(h_query);
	    	return (Languages)query.uniqueResult();
	    }  
    
}
