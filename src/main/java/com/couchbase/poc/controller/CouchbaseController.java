package com.couchbase.poc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.poc.service.PersonService;

@RestController
public class CouchbaseController {

	@Autowired
	PersonService personService;
	
	@GetMapping(path = "/get/documents")
	public ResponseEntity<List<Map<String, Object>>> getDetails() {
		List<Map<String, Object>> personList = personService.getPersonList();

		return new ResponseEntity<List<Map<String, Object>>>(personList, HttpStatus.OK);
	}
}
