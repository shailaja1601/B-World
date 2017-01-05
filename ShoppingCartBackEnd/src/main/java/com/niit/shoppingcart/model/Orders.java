package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")    //Optional if the table name is same as class name
@Component
public class Orders implements Serializable {
	private static final long serialVersionUID= 1L;

	@Id
	@Column(name="Orders_id")
	private int id;
	
	@Column(name="USER_MAIL_ID")
	private String user_mail_id;
	
	@Column(name="Cart_Id")//Optional if the property name in this class is same as field name in the table
	private int cartId;
	
	@Column(name="billing_address")
	private BillingAddress billingAddress;
	
	@Column(name="shipping_address")
	private ShippingAddress shippingAddress;
	
	@Column(name="payment_method")
	private String paymentMethod;
    
	private int totalAmount;
	
	

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUser_mail_id() {
		return user_mail_id;
	}

	public void setUser_mail_id(String user_mail_id) {
		this.user_mail_id = user_mail_id;
	}

	

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
