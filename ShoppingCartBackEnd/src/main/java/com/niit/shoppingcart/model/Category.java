package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="category")    //Optional if the table name is same as class name
@Component
public class Category {
	@Id
	@Column(name="CATEGORY_ID")
	private String categoryId;
	
	
	@Column(name="CATEGORY_NAME")//Optional if the property name in this class is same as field name in the table
	private String categoryName;
	
	@Column(name="DESCRIPTION")//optional
	private String description;
	
	@Transient
	 private MultipartFile image;
    
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private Set<Product> products;
		
	
  
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	 public void clear(){
		 this.categoryId="";
		 this.categoryName="";
		 this.description="";
	 }
     
}
