package com.nanna.demo.dao.impl;

import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.DAO.impl.BookDaoImpl;
import com.nanna.demo.domain.Author;
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

@ExtendWith ( MockitoExtension.class)
class AuthorDaoImplTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private AuthorDaoImpl underTest;
	
	@Test
	public void testThatCreateAuthorGeneratesCorrectSql (){
//		verify( jdbcTemplate ).update ( "INSERT INTO authors (id, name, age) VALUES (1, 'Abigail rose', 40)" );
		Author abigailRose = TestDataUtil.createTestAuthorA ();
		underTest.create ( abigailRose );
		verify ( jdbcTemplate ).update ( eq ( "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)" ) , eq ( 1L ) ,
				eq ( "Abigail rose" ) , eq ( 40 ) );
		
	}
	
	@Test
	public void testThatGenerateCorrectSql (){
		underTest.findOne ( 1L );
		verify ( jdbcTemplate ).query (
				eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1" ) ,
				ArgumentMatchers.< AuthorDaoImpl.AuthorRowMapper >any(),
				eq ( 1L ) );
	}
	
	@Test
	public void testThatfindManygenerateCorrectSql() {
// The code snippet verifies that a specific query is executed on a jdbcTemplate object, with specific parameters and a specific row mapper.
		underTest.find ();
		verify ( jdbcTemplate ).query (
				eq ( "SELECT id, name, age FROM authors"  ) ,
				any( AuthorDaoImpl.AuthorRowMapper.class)
		);
	}
	
//	WHERE id = ? LIMIT 1
//
	
}