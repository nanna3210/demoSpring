package com.nanna.demo.dao.impl;


import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith ( SpringExtension.class )
public class AuthorDaoImplIntegrationTest {
	
	
	

		private AuthorDaoImpl underTest;
		
		@Autowired
		public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
			this.underTest = underTest;
		}
		
		
	
		@Test
	public void testThatCreateAuthorandRecalled () {
			Author author = TestDataUtil.createTestAuthor ();
			
			underTest.create ( author );
			Optional < Author > result = underTest.findOne ( author.getId () );
			assertThat ( result ).isPresent ();
			
		}
		
		


}
