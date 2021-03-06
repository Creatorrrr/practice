package namoo.board.store.mybatis.mapper;

import java.util.List;

import namoo.board.domain.Comment;


public interface CommentMapper {

	int create(Comment comment);
	List<Comment> retrieveAll(String articleId);
	void delete(String commentId);
}
