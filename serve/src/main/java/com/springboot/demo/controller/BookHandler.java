package com.springboot.demo.controller;

import com.springboot.demo.entity.Book;
import com.springboot.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: latinos-bub
 * @date: 2020/6/14 21:53
 * @description:
 * @className: BookHandler
 */
@RestController
@RequestMapping("/book")
public class BookHandler {


	@Autowired
	private BookRepository bookRepository;


	@GetMapping("/findAll")
	public List<Book> findAll(){

		return bookRepository.findAll();
	}
}
