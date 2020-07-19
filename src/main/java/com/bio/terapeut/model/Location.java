package com.bio.terapeut.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="location")
@Data
public class Location {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="date_time_created_on")
	private Timestamp dateTimeCreatedOn;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="language")
	private String language;
	
	@OneToMany(mappedBy = "refLocationId")
	private Set<Appointment> appointments;
	
	@OneToMany(mappedBy = "refLocationId")
	private Set<ApplicationUser> users;
}
