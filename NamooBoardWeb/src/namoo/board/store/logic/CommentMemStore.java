package namoo.board.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import namoo.board.domain.Comment;
import namoo.board.store.CommentStore;

@Repository
public class CommentMemStore implements CommentStore {

	private BoardRepository repo;
	
	public CommentMemStore() {
		this.repo = BoardRepository.getInstance();
	}
	
	@Override
	public String create(Comment comment) {
		return repo.insertComment(comment);
	}

	@Override
	public List<Comment> retrieveAll(String articleId) {
		return repo.selectAllComment(articleId);
	}

	@Override
	public void delete(String commentId) {
		repo.deleteComment(commentId);
	}

}
