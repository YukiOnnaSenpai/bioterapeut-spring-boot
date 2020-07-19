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

import com.bio.terapeut.dao.MerchendiseDao;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.implementation.MerchendiseService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/merchendise")
public class MerchendiseController {

	private final MerchendiseService service;
	
	@GetMapping(value="/overview")
	public List<MerchendiseDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public MerchendiseDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<MerchendiseDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<MerchendiseDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<MerchendiseDao> save(@RequestBody MerchendiseDao dao) {
		service.save(dao);
		return new ResponseEntity<MerchendiseDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<MerchendiseDao> update (@RequestBody MerchendiseDao dao) {
		service.save(dao);
		return new ResponseEntity<MerchendiseDao>(HttpStatus.OK);
	}
}
