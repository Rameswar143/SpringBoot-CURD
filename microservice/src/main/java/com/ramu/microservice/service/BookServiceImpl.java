package com.ramu.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ramu.microservice.entity.Book;
import com.ramu.microservice.exception.BookNotFoundexception;
import com.ramu.microservice.repository.BookRepository;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	@Override
	public List<Book> findAll() {
		return repository.findAll();
	}

	@Override
	public Book save(Book book) {
		return repository.save(book);
	}

	@Override
	public Book findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new BookNotFoundexception("Book Not Found"));
	}

	@Override
	public void deleteById(Long id) {
		Book book = findById(id);
		repository.delete(book);
	}

	@Override
	public Book updatedBook(Long id, Book book) {
		Book savedBook = findById(id);
		savedBook.setTitle(book.getTitle());
		savedBook.setAuthor(book.getAuthor());
		savedBook.setDescription(book.getDescription());
		savedBook.setPublished(book.getPublished());
		return save(savedBook);
	}

}
