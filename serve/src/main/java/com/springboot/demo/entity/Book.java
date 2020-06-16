package com.springboot.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: latinos-bub
 * @date: 2020/6/14 20:51
 * @description:
 * @className: Book
 */
@Entity
@Data // lombok 自动提供getter/setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String cover; // 封面图
	String title;
	String author;
	String date;
	String press; // 出版社
	String abs; // 简介
	Integer cid; // 类别

}
