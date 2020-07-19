package com.bio.terapeut.dao;

import lombok.Data;

@Data
public class MerchendiseDao {
	
	private Long id;
	
	private String type;
	
	private String name;
	
	private Double price;
	
	private String description;
	
	private boolean hasStock;
	
	private LabelDao labelId;

}
