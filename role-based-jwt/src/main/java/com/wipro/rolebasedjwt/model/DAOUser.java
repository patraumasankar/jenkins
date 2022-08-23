package com.wipro.rolebasedjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class DAOUser {	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "phone_number")
	private String phone;
	
	@Column(name = "role_name")
	private String role;
	
	@Column
	@JsonIgnore
	private String password;

}
