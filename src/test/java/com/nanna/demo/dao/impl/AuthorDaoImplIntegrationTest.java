package com.nanna.demo.dao.impl;


import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith ( SpringExtension.class )
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTest {
	
	
	

		private AuthorDaoImpl underTest;
		
		@Autowired
		public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){
			this.underTest = underTest;
		}
		
		
	
		@Test
	public void testThatCreateAuthorandRecalled () {
			Author author = TestDataUtil.createTestAuthorA ();
			
			underTest.create ( author );
			Optional < Author > result = underTest.findOne ( author.getId () );
			assertThat ( result ).isPresent ();
			assertThat ( result.get () ).isEqualTo ( author );
			
		}
		
		
	@Test
	public void testThatCreateMultipleAuthorandRecalled () {
		Author authorA = TestDataUtil.createTestAuthorA ();
		underTest.create ( authorA );
		Author authorB = TestDataUtil.createTestAuthorB ();
		underTest.create ( authorB );
		Author authorC = TestDataUtil.createTestAuthorC ();
		underTest.create ( authorC );
		List < Author > result = underTest.find ();
		assertThat ( result ).hasSize ( 3 );
		assertThat ( result ).containsExactly ( authorA , authorB , authorC );
		
	}

}
