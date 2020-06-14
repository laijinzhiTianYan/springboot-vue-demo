package com.springboot.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: latinos-bub
 * @date: 2020/6/14 20:51
 * @description:
 * @className: Book
 */
@Entity
@Data // lomback 自动提供getter/setter
public class Book {

	@Id
	private Integer id;
	String cover;
	String title;
	String author;
	String date;

}
