package com.nanna.demo.DAO.impl;

import com.nanna.demo.DAO.BookDao;
//import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {

	private final JdbcTemplate jdbcTemplate;
	
	private static final String CREATE_BOOK = "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)";
	
	
	public BookDaoImpl (final  JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public static  class  BookRowMapper implements RowMapper<Books>{
		
		
		@Override
		public Books mapRow ( ResultSet rs , int rowNum ) throws SQLException {
			return Books.builder ()
					.isbn ( rs.getString ( "isbn" ) )
					.title ( rs.getString ( "title" ) )
					.authorId ( rs.getLong ( "author_id" ) )
					.build ();
		}
	}
	
	
	
	
	
	@Override
	public void create ( Books books ) {
		
		
		jdbcTemplate.update ( "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
				books.getIsbn (),
				books.getTitle (), books.getAuthorId () );
	}
	
	@Override
	public Optional < Books > findOne ( String  isbn ) {
		List < Books > results = jdbcTemplate.query ( "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1" , new BookRowMapper () , isbn );
		Optional < Books > first = results.stream ().findFirst ();
		return first;
	}
	
	@Override
	public List < Books > find ( ) {
		return jdbcTemplate.query ( "SelECT isbn, title, author_id FROM books ",new BookRowMapper () );
	}
}
