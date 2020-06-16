package com.springboot.demo.controller;

import com.springboot.demo.entity.Book;
import com.springboot.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



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


	@GetMapping("/findAll/{page}/{size}")
	public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

		Pageable pageable = PageRequest.of(page-1, size);
		return bookRepository.findAll(pageable);
	}


	@PostMapping("/save")
	public Book save(@RequestBody Book book){ // 因为是post请求，所以需要使用 @RequestBody 注解将 json 数据转成 java对象

		return bookRepository.save(book);
	}
}
