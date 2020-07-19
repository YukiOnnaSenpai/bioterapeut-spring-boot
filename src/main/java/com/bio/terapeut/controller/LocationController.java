package com.bio.terapeut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bio.terapeut.dao.LocationDao;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.implementation.LocationService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/location")
public class LocationController {

	private final LocationService service;
	
	@GetMapping(value="/overview")
	public List<LocationDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public LocationDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<LocationDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<LocationDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<LocationDao> save(@RequestBody LocationDao dao) {
		service.save(dao);
		return new ResponseEntity<LocationDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<LocationDao> update (@RequestBody LocationDao dao) {
		service.save(dao);
		return new ResponseEntity<LocationDao>(HttpStatus.OK);
	}
}
