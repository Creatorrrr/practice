package example.blog.store;

import java.util.List;

import example.blog.domain.Tag;

/**
 * TagStore
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface TagStore {

	boolean create(Tag tag);
	boolean delete(int tagId);
	boolean deleteByPostId(int postId);
	List<Tag> readByPostId(int postId);
}
