package example.blog.service;

import example.blog.domain.Blog;

/**
 * BlogService
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface BlogService {
	//
	boolean register(Blog blog);
	boolean modify(Blog blog);
	boolean remove(int blogId);
	Blog find(int blogId);
}