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
@Table(name="authors")
@Component
public class Authors {
	@Id
	@Column(name="AUTHORS_ID")
	private String authorsId;
	
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="ABOUT_AUTHOR")
	private String aboutAuthor;
	

	@OneToMany(mappedBy="authors",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	
	private Set<Product> products;
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getAuthorsId() {
		return authorsId;
	}

	public void setAuthorsId(String authorsId) {
		this.authorsId = authorsId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAboutAuthor() {
		return aboutAuthor;
	}

	public void setAboutAuthor(String aboutAuthor) {
		this.aboutAuthor = aboutAuthor;
	}
	
	 public void authorClear(){
		 this.authorsId="";
		 this.author="";
		 this.aboutAuthor="";
	 }
    
}
