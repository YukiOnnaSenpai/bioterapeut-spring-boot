package com.bio.terapeut.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="relation_user_appointment")
@Data
public class RelationUserAppointment {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private ApplicationUser refUserId;
	
	@ManyToOne
	@JoinColumn(name="appointment_id")
	private Appointment refAppointmentId;
	
	@Column(name="attendance_status")
	private String attendanceStatus;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="comment")
	private String comment;
}
