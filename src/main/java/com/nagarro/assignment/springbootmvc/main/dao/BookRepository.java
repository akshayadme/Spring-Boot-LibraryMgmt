package com.nagarro.assignment.springbootmvc.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.assignment.springbootmvc.main.model.BookModel;

public interface BookRepository extends CrudRepository<BookModel, Integer>{
	public List<BookModel> findByBookCode(String code);
	
	public BookModel findById(int id);
}
