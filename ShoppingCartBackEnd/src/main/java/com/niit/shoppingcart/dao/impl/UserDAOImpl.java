package com.niit.shoppingcart.dao.impl;

import java.util.List;

import org.h2.engine.Session;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	private static final Logger logger=LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	  private SessionFactory sessionFactory;
	   public UserDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	   @Transactional
	public boolean saveOrUpdate(User user) {
		try{
				sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	   @Transactional
	public boolean update(User user) {
		try{  
			if(get(user.getMail())==null){
				return false;
			}
			user=(User) sessionFactory.getCurrentSession().merge(user);
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(HibernateException e){
	      e.printStackTrace();		
		return false;
		}
	}
	   /* @Transactional
	public boolean delete(User user) {
		   
		try{
			User a=new User();
			a=get(user.getId());
			System.out.println(a.getId());
			if(get(user.getId())!=null){
				user=(User) sessionFactory.getCurrentSession().merge(user);
				sessionFactory.getCurrentSession().delete(user);
				return true;
				}
			else
			{
			return false;
				}
				}
		
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}*/  
	
	   @Transactional  
	   public User get(String mailID) {
		 logger.debug("User get(String id) function START");
		String hql="from User where mail="+"'"+mailID+"'"; 
		 logger.debug("User get(String id) function END");
		  return getUserName(hql);
		  }
	 
	 @Transactional
	public List<User> list() {
		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return  query.list();
	}
  @Transactional
      public User isValidUser(String userMailID, String password) {

         logger.debug("START:isValidUser");
		 logger.debug("User_MailID : " + userMailID);
		    String H_Query="from User where MAIL_ID="+ "'" +userMailID+ "'" + "and " + "PASSWORD=" + "'" +password+ "'" ;
			
       return getUserName(H_Query);
  }
	 
  @Transactional
private User getUserName(String H_Query) {
	 logger.debug("User getUserName function START");
        User user=null;
	Query query=sessionFactory.getCurrentSession().createQuery(H_Query);
	@SuppressWarnings("unchecked")
	List<User> list=(List<User>)query.list();
	if(list != null && !list.isEmpty())
	{
		user=(User)list.get(0);
	}
	return user;
}
}
	