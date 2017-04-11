package namoo.board.store;

import java.util.List;

import namoo.board.domain.Comment;


public interface CommentStore {

	String create(Comment comment);
	List<Comment> retrieveAll(String articleId);
	void delete(String commentId);
}
