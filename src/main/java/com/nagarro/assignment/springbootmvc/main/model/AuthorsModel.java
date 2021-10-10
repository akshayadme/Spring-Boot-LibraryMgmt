package com.nagarro.assignment.springbootmvc.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorsModel {	
	

	private int id;
	private String name;
	
	public AuthorsModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AuthorsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
