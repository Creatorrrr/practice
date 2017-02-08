package example.blog.service;

import example.blog.domain.Author;

/**
 * BlogService
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface AuthorService {
	//
	boolean register(Author author);
	boolean modify(Author author);
	boolean remove(String authorId);
	Author find(String authorId);
}