package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.model.Authors;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Languages;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.PaymentMethod;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
   @Bean(name="dataSource")
   public DataSource getH2DataSource(){
	       DriverManagerDataSource dataSource=new DriverManagerDataSource();
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUsername("shailaja");
	       
	        return dataSource;
   }
 private Properties getHibernateProperties(){
	 Properties properties=new Properties();
	 properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 return properties;
 }
 
 @Autowired
 @Bean(name="sessionFactory")
 public SessionFactory getsessionFactory(DataSource dataSource){
	 LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
      sessionBuilder.addProperties(getHibernateProperties());
      sessionBuilder.addAnnotatedClass(Category.class);
      sessionBuilder.addAnnotatedClass(Product.class);
      sessionBuilder.addAnnotatedClass(Cart.class);
      sessionBuilder.addAnnotatedClass(Orders.class);
      sessionBuilder.addAnnotatedClass(Supplier.class);
      sessionBuilder.addAnnotatedClass(User.class);
      sessionBuilder.addAnnotatedClass(Languages.class);
      sessionBuilder.addAnnotatedClass(Authors.class);
      sessionBuilder.addAnnotatedClass(BillingAddress.class);
      sessionBuilder.addAnnotatedClass(ShippingAddress.class);
      sessionBuilder.addAnnotatedClass(PaymentMethod.class);
       return sessionBuilder.buildSessionFactory();
 }
 @Autowired
 @Bean(name="transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
	           HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	              return transactionManager;
 }
}

