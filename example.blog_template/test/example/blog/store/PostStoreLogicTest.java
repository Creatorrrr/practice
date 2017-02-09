package example.blog.store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import example.blog.domain.Post;
import example.blog.store.logic.PostStoreLogic;

public class PostStoreLogicTest {

//	@Test
//	public void testNextId() {
//		PostStore ps = new PostStoreLogic();
//		
//		int result = ps.nextId();
//		
//		assertEquals(8, result);
//	}
//	
//	@Test
//	public void testCreate() {
//		PostStore ps = new PostStoreLogic();
//		
//		Post post = new Post();
//		post.setSubject("1234");
//		post.setContents("1234");
//		post.setBlogId(1234);
//		
//		boolean result = ps.create(post);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testUpdate() {
//		PostStore ps = new PostStoreLogic();
//		
//		Post post = new Post();
//		post.setId(6);
//		post.setSubject("4321");
//		post.setContents("4321");
//		post.setBlogId(4321);
//		
//		boolean result = ps.update(post);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testDelete() {
//		PostStore ps = new PostStoreLogic();
//		
//		boolean result = ps.delete(6);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testRead() {
//		PostStore ps = new PostStoreLogic();
//		
//		Post post = ps.read(1);
//		
//		assertEquals("mybatis", post.getSubject());
//	}
//	
//	@Test
//	public void testReadByBlogId() {
//		PostStore ps = new PostStoreLogic();
//		
//		List<Post> list = ps.readByBlogId(2);
//		
//		assertEquals("hibernate", list.get(0).getSubject());
//	}

}
