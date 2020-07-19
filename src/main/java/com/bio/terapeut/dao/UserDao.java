package com.bio.terapeut.dao;

import lombok.Data;

@Data
public class UserDao {
	
	private Long id;
	
	private String accountType;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	
	private LocationDao locationId;

}
