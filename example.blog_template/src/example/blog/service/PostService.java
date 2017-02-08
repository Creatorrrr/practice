package example.blog.service;

import java.util.List;

import example.blog.domain.Post;

/**
 * BlogService
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface PostService {
	//
	boolean register(Post post);
	boolean modify(Post post);
	boolean remove(int postId);
	Post find(int postId);
	List<Post> findByBlogId(int blogId);
}