package com.github.alvarolongueira.managerservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public ResponseEntity<String> get() {
		return new ResponseEntity<String>("", new HttpHeaders(), HttpStatus.OK);
	}

}
