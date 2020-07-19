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

import com.bio.terapeut.dao.RelationUADao;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.implementation.RelationUserAppointmentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/relation")
public class RelationController {
	
	private final RelationUserAppointmentService service;
	
	@GetMapping(value="/overview")
	public List<RelationUADao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public RelationUADao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<RelationUADao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<RelationUADao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<RelationUADao> save(@RequestBody RelationUADao dao) {
		service.save(dao);
		return new ResponseEntity<RelationUADao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<RelationUADao> update (@RequestBody RelationUADao dao) {
		service.save(dao);
		return new ResponseEntity<RelationUADao>(HttpStatus.OK);
	}

}
