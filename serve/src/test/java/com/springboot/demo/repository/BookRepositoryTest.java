package com.springboot.demo.repository;

import com.springboot.demo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void findAll(){

		System.out.println(bookRepository.findAll());

	}


//	@Test
//	void save(){
//
//		Book book = new Book();
//		book.setTitle("人间无情");
//		book.setAuthor("中二");
//
//		Book book1 = bookRepository.save(book);
//		System.out.println(book1);
//	}
}