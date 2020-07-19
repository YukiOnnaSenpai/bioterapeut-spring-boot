package com.bio.terapeut.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@RequestMapping(value = "")
public class HomeController {
	
	@GetMapping(value="/")
	public void returnHome() {
		
	}

}
