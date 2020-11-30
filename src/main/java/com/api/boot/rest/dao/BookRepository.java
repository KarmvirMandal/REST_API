package com.api.boot.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.boot.rest.entities.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);	

}
