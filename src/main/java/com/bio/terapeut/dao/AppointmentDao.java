package com.bio.terapeut.dao;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AppointmentDao {
	
	private Long id;
	
	private String type;
	
	private String description;
	
	private Timestamp dateTimeStart;
	
	private Timestamp dateTimeEnd;
	
	private double price;
	
	private LocationDao refLocationDaoId;
	
	private LabelDao refLabelDaoId;
	
}
