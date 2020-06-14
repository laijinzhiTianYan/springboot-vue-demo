package com.springboot.demo.repository;

import com.springboot.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: latinos-bub
 * @date: 2020/6/14 20:55
 * @description:
 * @className: BookRepository
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
