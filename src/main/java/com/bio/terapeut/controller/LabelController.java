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

import com.bio.terapeut.dao.LabelDao;
import com.bio.terapeut.dao.converter.UserConverter;
import com.bio.terapeut.repository.implementations.UserRepository;
import com.bio.terapeut.service.implementation.LabelService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/label")
public class LabelController {
	
	private final LabelService service;
	
	@GetMapping(value="/overview")
	public List<LabelDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public LabelDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<LabelDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<LabelDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<LabelDao> save(@RequestBody LabelDao dao) {
		service.save(dao);
		return new ResponseEntity<LabelDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<LabelDao> update (@RequestBody LabelDao dao) {
		service.save(dao);
		return new ResponseEntity<LabelDao>(HttpStatus.OK);
	}

}
