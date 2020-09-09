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

import com.bio.terapeut.dao.UserDao;
import com.bio.terapeut.service.implementation.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService service;
	
	@GetMapping(value="/overview")
	public List<UserDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public UserDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<UserDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<UserDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<UserDao> save(@RequestBody UserDao dao) {
		service.save(dao);
		return new ResponseEntity<UserDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<UserDao> update (@RequestBody UserDao dao) {
		service.save(dao);
		return new ResponseEntity<UserDao>(HttpStatus.OK);
	}
}
