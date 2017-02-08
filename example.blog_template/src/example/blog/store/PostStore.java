package example.blog.store;

import java.util.List;

import example.blog.domain.Post;

/**
 * PostStore
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface PostStore {
	//
	int nextId();
	boolean create(Post post);
	boolean update(Post post);
	boolean delete(int postId);
	Post read(int postId);
	List<Post> readByBlogId(int blogId);
}