package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="User")    //Optional if the table name is same as class name
@Component
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name="user" , strategy="increment")
	@GeneratedValue(generator="user")
	@Column(name="USERID")
	private int id;
	
	@NotEmpty(message="Please enter your name")
	@Column(name="NAME")
	private String name;
	
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="contact")
	private String contact;
	
	@Id
	@NotEmpty(message="Please enter your mail_Id")
	@Column(name="MAIL_ID")
	private String mail;
	
	@Column(name="ROLE")
	private String role;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	}
