package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

	@Query("select b from Books b where b.price>?1")
	List<Books> getBooksAbove(int number);
}
