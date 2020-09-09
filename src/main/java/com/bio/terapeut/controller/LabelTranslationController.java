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

import com.bio.terapeut.dao.LabelTranslationDao;
import com.bio.terapeut.service.implementation.LabelTranslationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/labelTranslation")
public class LabelTranslationController {
	
	private final LabelTranslationService service;
	
	@GetMapping(value="/overview")
	public List<LabelTranslationDao> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value="/overview/{id}")
	public LabelTranslationDao getById(@PathVariable Long id) {
		return service.getOneById(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<LabelTranslationDao> deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<LabelTranslationDao>(HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<LabelTranslationDao> save(@RequestBody LabelTranslationDao dao) {
		service.save(dao);
		return new ResponseEntity<LabelTranslationDao>(HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<LabelTranslationDao> update (@RequestBody LabelTranslationDao dao) {
		service.save(dao);
		return new ResponseEntity<LabelTranslationDao>(HttpStatus.OK);
	}

}
