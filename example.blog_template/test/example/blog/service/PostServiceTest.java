package example.blog.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import example.blog.domain.Post;
import example.blog.service.logic.PostServiceLogic;

public class PostServiceTest {

//	@Test
//	public void testRegister() {
//		PostService ps = new PostServiceLogic();
//		
//		Post post = new Post();
//		post.setSubject("1234");
//		post.setContents("1234");
//		post.setBlogId(1234);
//		
//		boolean result = ps.register(post);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testModify() {
//		PostService ps = new PostServiceLogic();
//		
//		Post post = new Post();
//		post.setId(8);
//		post.setSubject("4321");
//		post.setContents("4321");
//		post.setBlogId(4321);
//		
//		boolean result = ps.modify(post);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testRemove() {
//		PostService ps = new PostServiceLogic();
//		
//		boolean result = ps.remove(8);
//		
//		assertTrue(result);
//	}
//	
//	@Test
//	public void testFind() {
//		PostService ps = new PostServiceLogic();
//		
//		Post post = ps.find(1);
//		
//		assertEquals("mybatis", post.getSubject());
//	}
//	
//	@Test
//	public void testFindByBlogId() {
//		PostService ps = new PostServiceLogic();
//		
//		List<Post> list = ps.findByBlogId(2);
//		
//		assertEquals("hibernate", list.get(0).getSubject());
//	}

}
