package com.bhas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController 
{
	@GetMapping
	public ResponseEntity<String> greetMsg()
	{
		return new ResponseEntity<>("Gradle community welcomes you!", HttpStatus.TOO_MANY_REQUESTS);
	}
}
