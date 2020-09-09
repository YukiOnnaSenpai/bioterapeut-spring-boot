package com.bio.terapeut.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="label")
@Data
public class Label {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@Column(name="value")
	private String value;
	
	@OneToMany(mappedBy="refLabelId")
	private Set<Merchendise> merchendises;
	
	@OneToMany(mappedBy = "refLabelId")
	private Set<LabelTranslation> translations;
	
	@OneToMany(mappedBy = "refLabelId")
	private Set<Appointment> appointments;

}
