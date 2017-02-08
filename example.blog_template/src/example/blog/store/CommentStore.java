package example.blog.store;

import java.util.List;

import example.blog.domain.Comment;

/**
 * CommentStore
 * 
 * @author Eunyoung Kim(eykim@nextree.co.kr)
 * @sinse Mar 1, 2016
 */
public interface CommentStore {
	//
	boolean create(Comment comment);
	boolean delete(int commentId);
	boolean deleteByPostId(int postId);
	List<Comment> readByPostId(int postId);

}
