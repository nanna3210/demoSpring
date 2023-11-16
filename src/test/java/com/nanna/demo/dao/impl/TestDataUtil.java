package com.nanna.demo.dao.impl;

import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;

public class TestDataUtil {
	 private TestDataUtil(){
		
	 }
	
	static Author createTestAuthorA ( ) {
		return Author.builder ().id ( 1L ).name ( "Abigail rose" ).age ( 40 ).build ();
	}
	static Author createTestAuthorB ( ) {
		return Author.builder ().id ( 2L ).name ( "Thomas rose" ).age ( 41 ).build ();
	}
	static Author createTestAuthorC ( ) {
		return Author.builder ().id ( 3L ).name ( "Jesse rose" ).age ( 43 ).build ();
	}
	static Books createTestBookA ( ) {
		return Books.builder ().isbn ( "iq-234-dail-4765" ).title ( "the great gatsby" ).authorId ( 1L ).build ();
	}
	static Books createTestBookB ( ) {
		return Books.builder ().isbn ( "iq-234-dail-4766" ).title ( "the great Indians" ).authorId ( 1L ).build ();
	}
	static Books createTestBookC ( ) {
		return Books.builder ().isbn ( "iq-234-dail-4767" ).title ( "the great KOSHALS " ).authorId ( 1L ).build ();
	}
}
