package com.BookManage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookManage.model.Book;
import com.BookManage.service.BookService;



@RestController
@RequestMapping("/api/books")
public class bookcontroller {
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping()
	public List<Book> getallEmployees()
	{
		return bookservice.getAllBook();
	}
	@GetMapping("/{id}")
	public Book getEmployeebyid(@PathVariable Long id)
	{
		return Optional.ofNullable(bookservice.getBookById(id)).orElseThrow();
	}
	
	@PostMapping("/add")
	public Book insertEmployee(@RequestBody Book book)
	{
		return bookservice.saveBook(book);
	}
	
	@PutMapping("/update/{id}")
	public Book updateEmployee(@PathVariable Long id, @RequestBody Book bookdata)
	{
		
		Book book = bookservice.getBookById(id);
		
	 
		book.setTitle(bookdata.getTitle());
		book.setAuthor(bookdata.getAuthor());
		book.setPublished_year(bookdata.getPublished_year());
		book.setPublisher(bookdata.getPublisher());
		book.setOverview(bookdata.getOverview());
		
		return bookservice.saveBook(book);
	}
	

	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable Long id)
	{
		bookservice.deleteBookbyId(id);
	}
}



