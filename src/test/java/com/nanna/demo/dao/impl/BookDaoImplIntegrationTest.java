package com.nanna.demo.dao.impl;

// import com.nanna.demo.DAO.AuthorDao;
import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.DAO.impl.BookDaoImpl;
import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith ( SpringExtension.class )
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTest {
	
//	@Autowired
		private     AuthorDaoImpl authorDao;
//	@Autowired
	private BookDaoImpl   underTest;
	@Autowired
		public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDaoImpl authorDao ){
			this.underTest = underTest;
			this.authorDao = authorDao;
		}
		
		@Test
		public void testThatCreateBookandRecalled () {
			Author author = TestDataUtil.createTestAuthorA ();
			authorDao.create ( author );
			Books book = TestDataUtil.createTestBookA ();
			book.setAuthorId ( author.getId () );
			underTest.create ( book );
			
			Optional < Books > result = underTest.findOne ( book.getIsbn () );
			assertThat ( result ).isPresent ();
		}
	@Test
	public void testThatCreateMultipleBookandRecalled () {
		Author author = TestDataUtil.createTestAuthorA ();
		authorDao.create ( author );
		Books bookA = TestDataUtil.createTestBookA ();
		bookA.setAuthorId ( author.getId () );
		underTest.create ( bookA );
		Books bookB = TestDataUtil.createTestBookB ();
		bookB.setAuthorId ( author.getId () );
		underTest.create ( bookB );
		
		Books bookC = TestDataUtil.createTestBookC ();
		bookB.setAuthorId ( author.getId () );
		underTest.create ( bookC );
		
		List < Books > result  = underTest.find ();
		assertThat ( result ).hasSize ( 3 ).containsExactly ( bookA , bookB , bookC );
	}
	
}
