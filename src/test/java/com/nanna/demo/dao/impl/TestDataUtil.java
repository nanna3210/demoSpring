package com.nanna.demo.dao.impl;

import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;

public class TestDataUtil {
	 private TestDataUtil(){
		
	 }
	
	static Author createTestAuthor ( ) {
		return Author.builder ().id ( 1L ).name ( "Abigail rose" ).age ( 40 ).build ();
	}
	
	static Books createTestBook ( ) {
		return Books.builder ().isbn ( "iq-234-dail-4765" ).title ( "the great gatsby" ).authorId ( 1L ).build ();
	}
}
