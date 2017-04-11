package namoo.board.service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import namoo.board.domain.Article;
import namoo.board.domain.Board;
import namoo.board.domain.Comment;
import namoo.board.service.BoardService;
import namoo.board.store.logic.ArticleMemStore;
import namoo.board.store.logic.BoardMemStore;
import namoo.board.store.logic.CommentMemStore;

@Service
public class BoardServiceLogic implements BoardService {

	@Autowired
	private BoardMemStore boardStore;
	@Autowired
	private ArticleMemStore articleStore;
	@Autowired
	private CommentMemStore commentStore;
	
	@Override
	public void registerArticle(Article article) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		article.setRegDate(today);
		articleStore.create(article);
	}

	@Override
	public Article findArticle(String articleId) {
		Article article = articleStore.retrieve(articleId);
		
		if(article == null) {
			return null;
		}
		
		// Comment 추가
		
		return article;
	}

	@Override
	public Board findBoard(String boardId) {
		Board board = boardStore.retrieve(boardId);
		
		if(board == null) {
			return null;
		}
		
		List<Article> articles = articleStore.retrieveAll(boardId);
		board.setArticles(articles);
		
		return board;
	}

	@Override
	public void removeArticle(String articleId) {
		articleStore.delete(articleId);
	}

	@Override
	public void modifyArticle(Article article) {
		Article before = articleStore.retrieve(article.getArticleId());
		
		// 제목, 내용만 교체
		
		before.setTitle(article.getTitle());
		before.setContents(article.getContents());
		
		articleStore.update(before);
	}

	@Override
	public void registerBoard(Board board) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		board.setCreatedDate(today);
		
		boardStore.create(board);
	}

	@Override
	public List<Board> findAllBoards() {
		return boardStore.retrieveAll();
	}

	@Override
	public void modifyBoard(Board board) {
		boardStore.update(board);
	}

	@Override
	public void removeBoard(String boardId) {
		boardStore.delete(boardId);
	}

	@Override
	public void registerComment(Comment comment) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		comment.setRegDate(today);
		commentStore.create(comment);
	}

	@Override
	public void removeComment(String commentId) {
		commentStore.delete(commentId);
	}

}
