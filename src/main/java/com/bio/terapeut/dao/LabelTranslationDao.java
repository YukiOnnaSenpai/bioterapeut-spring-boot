package com.bio.terapeut.dao;

import lombok.Data;

@Data
public class LabelTranslationDao {
	
	private Long id;
	
	private String language;
	
	private String translationValue;
	
	private LabelDao labelId;

}
