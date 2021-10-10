package com.nagarro.assignment.springbootmvc.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment.springbootmvc.main.model.AuthorsModel;
import com.nagarro.assignment.springbootmvc.main.model.BookModel;
import com.nagarro.assignment.springbootmvc.main.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<AuthorsModel> getAuthors(){
		String url = "http://localhost:8081/getauthors";
		
		ResponseEntity<AuthorsModel[]> author = restTemplate.getForEntity(url, AuthorsModel[].class);
		List<AuthorsModel> res = Arrays.asList(author.getBody());
		
		return res;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView showDashboard() {

		ModelAndView modelview = new ModelAndView();

		List<BookModel> books = this.bookservice.getAllBooks();

		modelview.addObject("books", books);
		modelview.setViewName("dashboard");

		return modelview;

	}

	@RequestMapping(value="/getbook/{bookid}",method=RequestMethod.GET)
	public ModelAndView getBookById(@PathVariable("bookid") int bookid) {
		ModelAndView modelview = new ModelAndView();
		BookModel book = this.bookservice.getBookById(bookid);
		
		List<AuthorsModel> author = getAuthors();

		modelview.addObject("authors", author);
		modelview.addObject("book", book);
		modelview.setViewName("editBook");
		
		return modelview;		
	}

	@RequestMapping("/addBook")
	public String showAddPage(Model m) {
		List<AuthorsModel> author = getAuthors();
		
		m.addAttribute("authors", author);
		return "addBook";
	}

	@RequestMapping(value = "/addbookdata", method = RequestMethod.POST)
	public String addBook(@ModelAttribute BookModel book,Model m) {
		
		boolean res = this.bookservice.addBook(book);

		String redirect = null;
		if (res) {
			redirect = "redirect:/dashboard";
		} else {
			
			m.addAttribute("errorMsg", "Book already exist");
			redirect="addBook";
		}
		return redirect;
	}
	
	@RequestMapping(path = "/getbook/editbookdata", method = RequestMethod.POST)
	public String editBook(@ModelAttribute BookModel book) {
		int bookid = book.getId();
		this.bookservice.editBook(book, bookid);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/deletebook/{bookid}")
	public String deleteBook(@PathVariable("bookid") int bookid) {
		this.bookservice.deleteBook(bookid);
		return "redirect:/dashboard";
	}
}
