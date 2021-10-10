package com.nagarro.assignment.springbootmvc.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@Column(unique=true)
	private String bookCode;
	private String bookName;
	private String author;
	private String addedDate;
	
	public BookModel(int id, String bookCode, String bookName, String author, String addedDate) {
		super();
		this.id = id;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.addedDate = addedDate;
	}

	public BookModel() {
		super();
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "BookModel [id=" + id + ", bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author
				+ ", addedDate=" + addedDate + "]";
	}

	
	
	
}
