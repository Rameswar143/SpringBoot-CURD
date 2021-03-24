package com.ramu.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramu.microservice.entity.Book;
import com.ramu.microservice.service.BookService;

/**
 * @author PRAMESWA
 *
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.findAll());
	}

	@PostMapping("/books/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.save(book));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		return ResponseEntity.ok(bookService.updatedBook(id,book));

	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
		bookService.deleteById(id);
		return ResponseEntity.ok("Employee '" + id + "' deleted ");
	}
}
