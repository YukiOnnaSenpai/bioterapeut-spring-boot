package com.bio.terapeut.dao;

import lombok.Data;

@Data
public class RelationUADao {
	
	private Long id;
	
	private UserDao userId;
	
	private String attendanceStatus;
	
	private int rating;
	
	private String comment;
	
	private AppointmentDao appointmentId;

}
