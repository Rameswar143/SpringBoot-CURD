package com.ramu.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramu.microservice.entity.Book;

/**
 * @author PRAMESWA
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
