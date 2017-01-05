package com.niit.shoppingcart.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;



@Repository("cartDAO")
public class CartDAOImpl implements CartDAO,Serializable{
	private static final long serialVersionUID= 1L;

	@Autowired
	  SessionFactory sessionFactory;
	   public CartDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	  @Transactional
	public boolean save(Cart cart) {
		try{ 
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	 @Transactional
	public boolean update(Cart cart) {
		try{
			if(get(cart.getId())==null){
				return false;
			}
			cart=(Cart) sessionFactory.getCurrentSession().merge(cart);
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(HibernateException e){
	      e.printStackTrace();		
		return false;
		}
	}
	  @Transactional
	public boolean delete(int id) {
		  
		/*  Category CategoryToDelete=new Category();
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
				}*/
		   
		
			Cart cartDelete=new Cart();
			cartDelete.setId(id);
			
				try{
				sessionFactory.getCurrentSession().delete(cartDelete);
				return true;
				}
		
				
		
		catch(HibernateException e){
			e.printStackTrace();
		return false;
		}
	}
	/* @Transactional  
	 public Cart get(String mailID) {
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class,mailID);
	}*/
	 
	 @Transactional
	  public List<Cart> getbyUser (String mailID){
		String hql="from Cart where userMailId= " + "'" + mailID + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return  query.list();
	}

	public Cart get(int id) {
		String hql="from Cart where id= " + "'" + id + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart=(List<Cart>)query.list();
		 if(listCart!=null && !listCart.isEmpty()){
			 return listCart.get(0);
		 }
		 return null;
	}
   
	
	/*public int getMaxId()
	{
		int maxID=10;
		try{
			String hql="select max(id) from Cart";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			maxID=(Integer)query.uniqueResult();
			}
		catch(HibernateException e){
			maxID=100;
			e.printStackTrace();
		}
		return maxID+1;
	}*/
	
	 @Transactional
		public Long getTotalAmount(String userMailId){
		  String hql="select sum(price) from Cart where userMailId= " + "'" + userMailId + "'";
		  Query query= sessionFactory.getCurrentSession().createQuery(hql);
		  Long sum=(Long) query.uniqueResult();
		  return sum;
	  }

}
