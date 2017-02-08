package example.blog.store;

import static org.junit.Assert.*;

import org.junit.Test;

import example.blog.domain.Author;
import example.blog.store.logic.AuthorStoreLogic;

public class AuthorStoreTest {

//	@Test
//	public void testCreate() {
//		AuthorStore as = new AuthorStoreLogic();
//		
//		Author author = new Author();
//		author.setId("1234");
//		author.setPassword("1234");
//		author.setName("1234");
//		author.setEmail("1234");
//		
//		boolean result = as.create(author);
//		
//		assertTrue(result);
//	}

//	@Test
//	public void testUpdate() {
//		AuthorStore as = new AuthorStoreLogic();
//		
//		Author author = new Author();
//		author.setId("1234");
//		author.setPassword("4321");
//		author.setName("4321");
//		author.setEmail("4321");
//		
//		boolean result = as.update(author);
//		
//		assertTrue(result);
//	}
//
//	@Test
//	public void testDelete() {
//		AuthorStore as = new AuthorStoreLogic();
//		
//		boolean result = as.delete("1234");
//		
//		assertTrue(result);
//	}

	@Test
	public void testRead() {
		AuthorStore as = new AuthorStoreLogic();
		
		Author author = as.read("demonpark");
		
		assertEquals("demonpark", author.getId());
	}

}
