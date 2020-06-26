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
//		book.setId(71); // 这个报红，是由于idea的 maven 导致的，不用理会即可
//		book.setTitle("测试");
//		Book book1 = bookRepository.save(book);
//		System.out.println(book1);
//	}




	// 测试一下 findById
	@Test
	void findById(){

		Book book = bookRepository.findById(2).get();
		System.out.println(book);
	}


	@Test
	void deleteById(){
		String result = "";
		try {
			bookRepository.deleteById(111);
			result = "success";
		}catch (Exception e){
			result = "failure";
		}

		System.out.println(result);

	}
}