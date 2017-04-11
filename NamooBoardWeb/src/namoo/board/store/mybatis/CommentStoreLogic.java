package namoo.board.store.mybatis;

import java.util.List;

import namoo.board.domain.Comment;
import namoo.board.store.CommentStore;

public class CommentStoreLogic implements CommentStore {

	@Override
	public String create(Comment comment) {
		return null;
	}

	@Override
	public List<Comment> retrieveAll(String articleId) {
		return null;
	}

	@Override
	public void delete(String commentId) {

	}

}
