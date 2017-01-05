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
@Table(name="languages")
@Component
public class Languages {
	
	@Id
	@Column(name="LANGUAGE_ID")
	private String id;
	
	
	@Column(name="LANGUAGE")
	private String language;
	
	
	@OneToMany(mappedBy="languages",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Product> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public void languagesClear(){
		 this.id="";
		 this.language="";
	 }

}
