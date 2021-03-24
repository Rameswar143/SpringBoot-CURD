package com.ramu.microservice.service;

import java.util.List;

import com.ramu.microservice.entity.Book;

public interface BookService {

	List<Book> findAll();

	Book save(Book book);

	Book findById(Long id);

	void deleteById(Long id);

	Book updatedBook(Long id, Book book);


}
