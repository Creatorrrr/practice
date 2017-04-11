package namoo.board.service;

import java.util.List;

import namoo.board.domain.Article;
import namoo.board.domain.Board;
import namoo.board.domain.Comment;


public interface BoardService {
    
    /**
     * 게시글 등록하기
     * 
     * @param article
     */
    void registerArticle(Article article);
    
    /**
     * 게시글 조회하기
     * 
     * @param articleId
     * @return
     */
    Article findArticle(String articleId);
    
    /**
     * 게시판 조회 (등록된 게시글 목록조회)
     * 
     * @param boardId
     * @return
     */
    Board findBoard(String boardId);

    /**
     * 게시물 삭제
     * 
     * @param articleId
     */
	void removeArticle(String articleId);

	/**
	 * 게시물 수정
	 * 
	 * @param article
	 */
	void modifyArticle(Article article);

	/**
	 * 게시판 등록
	 * 
	 * @param board
	 */
	void registerBoard(Board board);

	/**
	 * 게시판 목록
	 * 
	 * @return
	 */
	List<Board> findAllBoards();
	
	/**
	 * 게시판 수정
	 * 
	 * @param board
	 */
	void modifyBoard(Board board);

	/**
	 * 게시판 삭제
	 * 
	 * @param boardId 게시판 아이디
	 */
	void removeBoard(String boardId);
	
	/**
	 * 댓글 등록
	 * 
	 * @param comment 댓글 정보
	 */
	
	void registerComment(Comment comment);
	
	/**
	 * 댓글 삭제
	 * 
	 * @param commentId 댓글 아이디
	 */
	void removeComment(String commentId);
}
