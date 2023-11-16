package com.nanna.demo.DAO;

import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;

import java.util.List;
import java.util.Optional;

public interface BookDao {
	
	void create ( Books books );
	
	Optional< Books > findOne ( String  isbn );
	
	
	List <Books> find ( );
}
