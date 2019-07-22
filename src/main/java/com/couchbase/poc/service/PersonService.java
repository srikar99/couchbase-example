package com.couchbase.poc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.poc.dao.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo personRepo;
	
	public List<Map<String, Object>> getPersonList() {
		return personRepo.getPersonList();
	}
}
