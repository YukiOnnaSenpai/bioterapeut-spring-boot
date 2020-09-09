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

import com.bio.terapeut.dao.AppointmentDao;
import com.bio.terapeut.service.implementation.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/appointment")
public class AppointmentController {
	
	private final AppointmentService service;
	
	@GetMapping(value="/overview")
	public List<AppointmentDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public AppointmentDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<AppointmentDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<AppointmentDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<AppointmentDao> save(@RequestBody AppointmentDao dao) {
		service.save(dao);
		return new ResponseEntity<AppointmentDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<AppointmentDao> update (@RequestBody AppointmentDao dao) {
		service.save(dao);
		return new ResponseEntity<AppointmentDao>(HttpStatus.OK);
	}
}
