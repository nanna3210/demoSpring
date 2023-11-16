package com.nanna.demo.dao.impl;

import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.DAO.impl.BookDaoImpl;
import com.nanna.demo.domain.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;


@ExtendWith ( MockitoExtension.class )
class BookDaoImplTest {
	
	
	@Mock
	private JdbcTemplate jdbcTemplate;

	@InjectMocks
	private BookDaoImpl underTest;
	
	
	@Test
	public void testThatCreateBookGeneratesCorrectSql (){
		Books theGreatGatsby = TestDataUtil.createTestBookA ();
		underTest.create ( theGreatGatsby );
		verify ( jdbcTemplate ).update (
				eq ( "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)" ) ,
				eq ( "iq-234-dail-4765" )  , eq ( "the great gatsby" ) , eq ( 1L ));
		
	}
	
	@Test
	public void testThatFeneratesFindOneBookCorrectSql() {
		underTest.findOne (  "iq-234-dail-4765" );
		verify ( jdbcTemplate ).query (
				eq ( "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1" ) ,
				ArgumentMatchers.< BookDaoImpl.BookRowMapper >any(),
				eq ( "iq-234-dail-4765" )
		);
	}
	@Test
	public void testThatFindAllBookGeneratesCorrectSql() {
		underTest.find ();
		verify ( jdbcTemplate ).query (eq ( "SELECT isbn, title, author_id FROM books" )
				,ArgumentMatchers.< BookDaoImpl.BookRowMapper >any());
//				,any( AuthorDaoImpl.AuthorRowMapper.class));
		
	}
	
	
	


}