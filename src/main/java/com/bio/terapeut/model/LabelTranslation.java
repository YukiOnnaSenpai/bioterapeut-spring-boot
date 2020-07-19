package com.bio.terapeut.model;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="label_translation")
@Data
public class LabelTranslation {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@Column(name="language")
	private String language;
	
	@Column(name="translation_value")
	private String translationValue;
	
	@ManyToOne
	@JoinColumn(name="label_id")
	private Label refLabelId;
	

}
