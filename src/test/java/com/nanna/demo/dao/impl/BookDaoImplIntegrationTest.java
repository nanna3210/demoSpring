package com.nanna.demo.dao.impl;

// import com.nanna.demo.DAO.AuthorDao;
import com.nanna.demo.DAO.impl.AuthorDaoImpl;
import com.nanna.demo.DAO.impl.BookDaoImpl;
import com.nanna.demo.domain.Author;
import com.nanna.demo.domain.Books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.awt.print.Book;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith ( SpringExtension.class )
public class BookDaoImplIntegrationTest {
	
		private     AuthorDaoImpl authorDao;
		private BookDaoImpl   underTest;
		public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDaoImpl authorDao ){
			this.underTest = underTest;
			this.authorDao = authorDao;
		}
		
		@Test
		public void testThatCreateBookandRecalled () {
			Author author = TestDataUtil.createTestAuthor ();
			authorDao.create ( author );
			Books book = TestDataUtil.createTestBook ();
			book.setAuthorId ( author.getId () );
			underTest.create ( book );
			
			Optional < Books > result = underTest.findOne ( book.getIsbn () );
			assertThat ( result ).isPresent ();
		}
	
}
