package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<>();
		booksRepository.findAll().forEach(bookAdd -> books.add(bookAdd));
		return books;
	}

	public Books getBooksById(Integer id) {
		return booksRepository.findById(id).get();
	}

	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	public void delete(Integer id) {
		booksRepository.deleteById(id);
	}

	public void update(Books books, Integer bookid) {
		booksRepository.save(books);
	}

	public List<Books> getAbove(int id) {
		List<Books> books = new ArrayList<>();
		booksRepository.getBooksAbove(id).forEach(bookAdd -> books.add(bookAdd));
		return books;
	}
}
