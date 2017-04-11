package namoo.board.store.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import namoo.board.domain.Article;
import namoo.board.domain.Board;
import namoo.board.domain.Comment;


public class BoardRepository {
    
    private static BoardRepository instance;
    
    private Map<String, Board> boardMap;
    private Map<String, Article> articleMap;
    private Map<String, Comment> commentMap;
    private int nextBoardId;
    private int nextArticleId;
    private int nextCommentId;
    
    private BoardRepository() {
        //
        this.boardMap = new LinkedHashMap<String, Board>();
        this.articleMap = new HashMap<String, Article>();
        this.commentMap = new HashMap<String, Comment>();
    }
    
    public synchronized static BoardRepository getInstance() {
        //
        if (instance == null) {
            instance = new BoardRepository();
        }
        return instance;
    }
    
    public String insertBoard(Board board) {
        //
        String boardId = String.valueOf(++nextBoardId);
        board.setBoardId(boardId);
        boardMap.put(boardId, board);
        
        return boardId;
    }
    
    public Board selectBoard(String boardId) {
        //
        return boardMap.get(boardId);
    }
    
    public void updateBoard(Board board) {
        //
        boardMap.put(board.getBoardId(), board);
    }
    
    public void deleteBoard(String boardId) {
        //
        boardMap.remove(boardId);
    }
    
    public String insertArticle(Article article) {
        //
        String articleId = String.valueOf(++nextArticleId);
        article.setArticleId(articleId);
        articleMap.put(articleId, article);
        
        Board board = boardMap.get(article.getBoardId());
        board.addArticle(article);
        
        return articleId;
    }
    
    public Article selectArticle(String articleId) {
        //
        return articleMap.get(articleId);
    }
    
    public List<Article> selectAllArticle(String boardId) {
        //
        Board board = boardMap.get(boardId);
        if (board != null) {
            return board.getArticles();
        }
        
        return null;
    }    
    
    public void updateArticle(Article article) {
        //
        articleMap.put(article.getArticleId(), article);
    }
    
    public void deleteArticle(String articleId) {
        //
        Article article = articleMap.get(articleId);
        
        if (article != null) {
            //
            articleMap.remove(articleId);
            
            Board board = boardMap.get(article.getBoardId());
            if (board != null) {
                board.removeArticle(article);
            }
        }
    }

	public List<Board> selectAllBoards() {
		//
		List<Board> boards = 
			new ArrayList<Board>(boardMap.values());
		
		return boards;
	}
	
	public String insertComment(Comment comment) {
		//
        String commentId = String.valueOf(++nextCommentId);
        comment.setCommentId(commentId);
        commentMap.put(commentId, comment);
        
        Article article = articleMap.get(comment.getArticleId());
        article.addComment(comment);
        
        return commentId;
	}
	
	public List<Comment> selectAllComment(String articleId) {
		//
        Article article = articleMap.get(articleId);
        if (article != null) {
            return article.getComments();
        }
        
        return null;
	}
	
	public void deleteComment(String commentId) {
        //
        Comment comment = commentMap.get(commentId);
        
        if (comment != null) {
            //
            commentMap.remove(commentId);
            
            Article article = articleMap.get(comment.getArticleId());
            if (article != null) {
                article.removeComment(comment);
            }
        }
    }
}
