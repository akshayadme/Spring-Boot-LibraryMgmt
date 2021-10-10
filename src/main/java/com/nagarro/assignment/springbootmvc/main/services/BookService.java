package com.nagarro.assignment.springbootmvc.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.assignment.springbootmvc.main.dao.BookRepository;
import com.nagarro.assignment.springbootmvc.main.model.BookModel;

@Component
public class BookService {

	@Autowired
	private BookRepository bookrepo;
	
	public List<BookModel> getAllBooks(){
		List<BookModel> books = (List<BookModel>) this.bookrepo.findAll();
		return books;
	}
	
	public BookModel getBookById(int bookid) {
		BookModel book = this.bookrepo.findById(bookid);
		return book;
	}
	
	
	public boolean addBook(BookModel book){
		String code = book.getBookCode();
	
		List<BookModel> books = (List<BookModel>) this.bookrepo.findByBookCode(code);
		
		if(books.size() > 0 ) {
			return false;
		}
		else {
			this.bookrepo.save(book);
			return true;
		}
	}
	
	public void editBook(BookModel book,int bookid){
		BookModel bookres = this.bookrepo.findById(bookid);
		bookres.setBookCode(book.getBookCode());
		bookres.setBookName(book.getBookName());
		bookres.setAuthor(book.getAuthor());
		bookres.setAddedDate(book.getAddedDate());
		this.bookrepo.save(bookres);
		
	}
	
	public void deleteBook(int bookid) {
		
		this.bookrepo.deleteById(bookid);
		
	}
	
	
}
