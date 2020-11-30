package com.api.boot.rest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.boot.rest.dao.BookRepository;
import com.api.boot.rest.entities.Book;

@Component
public class BookService {

	// ***********fake data base services*************************

//	private static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(12, "Fundamental of java", "ABCDEF"));
//		list.add(new Book(30, "Fundamental of spring boot", "XYZ"));
//		list.add(new Book(34, "Fundamental of spring mvc", "LMNOP"));
//
//	}
	
	@Autowired
	private BookRepository bookRepository;

	// get all books
//	public List<Book> getAllBooks() {
//		return list;
//	}
	
	public List<Book> getAllBooks() {
		List<Book>list=(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	
	
	
	// get single book by id

//	public Book getBookById(int id) {
//		Book book = null;
//		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//		return book;
//	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			
			book = this.bookRepository.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	   
	// Adding the Book
//	public Book addBook(Book b) {
//		list.add(b);
//		return b;
//	}
	
	public Book addBook(Book b) {
	Book result = bookRepository.save(b);
		return result;
	}
		
	
	// Delete book

	public void deleteBook(int bid) {
		//list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}

	// Update book

	public void updateBook(Book book, int bookId) {
//		list = list.stream().map(b -> {
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
	}
}
