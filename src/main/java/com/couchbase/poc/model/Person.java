package com.couchbase.poc.model;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.couchbase.client.java.repository.annotation.Field;

import lombok.Data;

@Data
@JsonSerialize
public class Person {

	@Field
	private int id;
	@Field
	private String name;
	@Field
	private String emailId;
}
