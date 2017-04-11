package namoo.board.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {

    private static final long serialVersionUID = -7755173628930202505L;
    
    private String boardId;
    private String name;
    private Date createdDate;
    private String creatorName;
    private List<Article> articles;

    public String getBoardId() {
        return boardId;
    }
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getCreatorName() {
        return creatorName;
    }
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    public void removeArticle(Article article) {
        //
        if (articles != null) {
            articles.remove(article);
        }
    }
    
    public void addArticle(Article article) {
        //
        if (articles == null) {
            articles = new ArrayList<Article>();
        }
        
        articles.add(article);
    }
}
