package namoo.board.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Article implements Serializable {

    private static final long serialVersionUID = -4946269376442479040L;
    
    private String articleId;
    private String title;
    private String authorName;
    private Date regDate;
    private String contents;
    
    private String boardId;
    
    private List<Comment> comments;

    public String getArticleId() {
        return articleId;
    }
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getBoardId() {
        return boardId;
    }
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
    public void removeComment(Comment comment) {
        //
        if (comments != null) {
            comments.remove(comment);
        }
    }
    
    public void addComment(Comment comment) {
        //
        if (comments == null) {
            comments = new ArrayList<Comment>();
        }
        
        comments.add(comment);
    }
}
