package com.bio.terapeut.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="appointment")
@Data
public class Appointment {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_time_start")
	private Timestamp dateTimeStart;
	
	@Column(name="date_time_end")
	private Timestamp dateTimeEnd;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location refLocationId;
	
	@ManyToOne
	@JoinColumn(name="label_id")
	private Label refLabelId;
	
	@OneToMany(mappedBy="refAppointmentId")
	private Set<RelationUserAppointment> relations;

}
