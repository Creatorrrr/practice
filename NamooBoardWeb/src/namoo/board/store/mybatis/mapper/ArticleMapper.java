package namoo.board.store.mybatis.mapper;

import java.util.List;

import namoo.board.domain.Article;


public interface ArticleMapper {
    
    String create(Article article);
    Article retrieve(String articleId);
    List<Article> retrieveAll(String boardId);
    void update(Article article);
    void delete(String articleId);
}
