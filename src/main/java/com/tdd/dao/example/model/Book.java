package com.tdd.dao.example.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 6405194974534520861L;

	private String name;
	private String author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
