package example.blog.store;

import example.blog.domain.Blog;

/**
 * BlogStore
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface BlogStore {
	//
	boolean create(Blog blog);
	boolean update(Blog blog);
	boolean delete(int blogId);
	Blog read(int blogId);
}