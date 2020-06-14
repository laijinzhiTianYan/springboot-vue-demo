package com.springboot.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookRepositoryTest {

	@Autowired
	private BookRepository book;

	@Test
	void findAll(){

		System.out.println(book.findAll());

	}
}