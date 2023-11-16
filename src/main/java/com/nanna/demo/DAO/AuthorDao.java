package com.nanna.demo.DAO;

import com.nanna.demo.domain.Author;

import java.util.List;

public interface AuthorDao {
	
	void create ( Author author );
	
	List <Author> find ( );
	
}
