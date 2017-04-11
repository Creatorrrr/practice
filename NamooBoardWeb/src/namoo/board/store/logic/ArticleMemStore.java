package namoo.board.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import namoo.board.domain.Article;
import namoo.board.store.ArticleStore;


@Repository
public class ArticleMemStore implements ArticleStore {

    private BoardRepository repo;
    
    public ArticleMemStore() {
        //
        this.repo = BoardRepository.getInstance();
    }
    
    @Override
    public String create(Article article) {
        //
        return repo.insertArticle(article);
    }

    @Override
    public Article retrieve(String articleId) {
        // 
        return repo.selectArticle(articleId);
    }

    @Override
    public List<Article> retrieveAll(String boardId) {
        // 
        return repo.selectAllArticle(boardId);
    }

    @Override
    public void update(Article article) {
        // 
        repo.updateArticle(article);
    }

    @Override
    public void delete(String articleId) {
        //
        repo.deleteArticle(articleId);
    }

}
