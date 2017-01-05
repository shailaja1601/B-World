package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")    //Optional if the table name is same as class name
@Component
public class Supplier {
	
	@Id
	@Column(name="SUPPLIER_ID")
	private String supplierId;
	
	
	@Column(name="SUPPLIER_NAME")//Optional if the property name in this class is same as field name in the table
	private String supplierName;
	
	@Column(name="ADDRESS")//optional
	private String address;
	
	
	@OneToMany(mappedBy="supplier",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	
	private Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
	 public void supplierclear(){
		 this.supplierId="";
		 this.supplierName="";
		 this.address="";
	 }
	
}
