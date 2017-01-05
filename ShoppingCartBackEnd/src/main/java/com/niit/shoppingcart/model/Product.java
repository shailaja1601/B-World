package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")    //Optional if the table name is same as class name
@Component
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	    @Id
		@Column(name="PRODUCT_ID")
		private String productId;
		
		
		@Column(name="PRODUCT_NAME")//Optional if the property name in this class is same as field name in the table
		private String productName;
		
		@Column(name="PRICE")//optional
		private int price;
		
		@Column(name="AUTHORS_ID")
		private String authorID;
		
		@Column(name="LANGUAGE_ID")
		private String languageID;
		
		@Column(name="CATEGORY_ID")
		private String categoryID;
			
		@Column(name="SUPPLIER_ID")
		private String supplierID;
		
		@Column(name="STOCK")
        private int stock;
		
		@Column(name="DESCRIPTION")
		private String description;
		
		@Transient
		@Column(name="DATE_ADDED")
		private Date dateAdded;
		
		@Transient
		 private MultipartFile image;
         
		
		@ManyToOne
	    @JoinColumn(name="AUTHORS_ID",nullable=false, updatable=false,insertable=false)
        private Authors authors;
		
	
		@ManyToOne
		@JoinColumn(name="LANGUAGE_ID",nullable=false, updatable=false,insertable=false)
		private Languages languages;
		
		
		@ManyToOne
		@JoinColumn(name="SUPPLIER_ID",nullable=false, updatable=false,insertable=false)
		private Supplier supplier;
		
	    
		@ManyToOne
		@JoinColumn(name="CATEGORY_ID",nullable=false, updatable=false,insertable=false)
		private Category category;


		public String getProductId() {
			return productId;
		}


		public void setProductId(String productId) {
			this.productId = productId;
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


		public String getAuthorID() {
			return authorID;
		}


		public void setAuthorID(String authorID) {
			this.authorID = authorID;
		}


		public String getLanguageID() {
			return languageID;
		}


		public void setLanguageID(String languageID) {
			this.languageID = languageID;
		}


		public String getCategoryID() {
			return categoryID;
		}


		public void setCategoryID(String categoryID) {
			this.categoryID = categoryID;
		}


		public String getSupplierID() {
			return supplierID;
		}


		public void setSupplierID(String supplierID) {
			this.supplierID = supplierID;
		}


		public int getStock() {
			return stock;
		}


		public void setStock(int stock) {
			this.stock = stock;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Date getDateAdded() {
			return dateAdded;
		}


		public void setDateAdded(Date dateAdded) {
			this.dateAdded = dateAdded;
		}


		public MultipartFile getImage() {
			return image;
		}


		public void setImage(MultipartFile image) {
			this.image = image;
		}


		public Authors getAuthors() {
			return authors;
		}


		public void setAuthors(Authors authors) {
			this.authors = authors;
		}


		public Languages getLanguages() {
			return languages;
		}


		public void setLanguages(Languages languages) {
			this.languages = languages;
		}


		public Supplier getSupplier() {
			return supplier;
		}


		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}


		public Category getCategory() {
			return category;
		}


		public void setCategory(Category category) {
			this.category = category;
		}
		
		public void productClear(){
			 this.productId="";
			 this.productName="";
			 this.price=0;
			 this.stock=0;
			 this.description="";
			 
		 }

     		}		
