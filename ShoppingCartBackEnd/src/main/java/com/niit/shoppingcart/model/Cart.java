package com.niit.shoppingcart.model;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity

@Table(name="CART")    //Optional if the table name is same as class name
@Component

public class Cart  implements Serializable{
	private static final long serialVersionUID= 1L;

	@Id
	@GenericGenerator(name="Shailaja" , strategy="increment")
	@GeneratedValue(generator="Shailaja")

	@Column(name="Cart_ID")
	private int id;
	
	@Column(name="MAIL_ID")
	private String userMailId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRICE")
	private int price;
	
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Transient
	@Column(name="DATE_ADDED")
	private Date dateAdded;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
	

	
