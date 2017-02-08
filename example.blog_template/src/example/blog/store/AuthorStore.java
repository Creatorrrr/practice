package example.blog.store;

import example.blog.domain.Author;

/**
 * AuthorStore
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface AuthorStore {
	//
	boolean create(Author author);
	boolean update(Author author);
	boolean delete(String authorId);
	Author read(String authorId);
}