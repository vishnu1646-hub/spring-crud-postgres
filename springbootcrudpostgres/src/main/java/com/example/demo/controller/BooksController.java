package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.service.BooksService;

@RestController
public class BooksController {

	@Autowired
	private BooksService booksService;

	@GetMapping("/getBooks")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/getBooks/{bookid}")
	private Books getOneBook(@PathVariable("bookid") Integer bookid) {
		return booksService.getBooksById(bookid);
	}

	@DeleteMapping("/getBooks/{bookid}")
	private void deleteBook(@PathVariable("bookid") Integer bookid) {
		booksService.delete(bookid);
	}

	@PostMapping("/saveBooks")
	private Books saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}

	@PutMapping("/saveBooks")
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}

	@GetMapping("/select/{number}")
	private List<Books> getAboveBooks(@PathVariable("number") int number) {
		return booksService.getAbove(number);

	}

}
