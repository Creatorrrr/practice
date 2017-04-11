package namoo.board.store.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import namoo.board.domain.Comment;
import namoo.board.store.CommentStore;
import namoo.board.store.mybatis.mapper.CommentMapper;

@Repository
public class CommentStoreLogic implements CommentStore {

	@Override
	public String create(Comment comment) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		mapper.create(comment);
		session.close();
		
		// 생성된 sequence를 반환해야 한다.
		return comment.getCommentId();
	}

	@Override
	public List<Comment> retrieveAll(String articleId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		List<Comment> comments = mapper.retrieveAll(articleId);
		session.close();
		
		// 생성된 sequence를 반환해야 한다.
		return comments;
	}

	@Override
	public void delete(String commentId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		mapper.delete(commentId);
		session.close();
	}

}
