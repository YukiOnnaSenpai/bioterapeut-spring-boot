package com.bio.terapeut.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="application_user")
@Data
public class ApplicationUser {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location refLocationId;
	
	@OneToMany(mappedBy="refUserId")
	private Set<RelationUserAppointment> relations;
}
