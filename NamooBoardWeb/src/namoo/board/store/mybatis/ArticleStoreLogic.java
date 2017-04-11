package namoo.board.store.mybatis;

import java.util.List;

import namoo.board.domain.Article;
import namoo.board.store.ArticleStore;

public class ArticleStoreLogic implements ArticleStore {

	@Override
	public String create(Article article) {
		return null;
	}

	@Override
	public Article retrieve(String articleId) {
		return null;
	}

	@Override
	public List<Article> retrieveAll(String boardId) {
		return null;
	}

	@Override
	public void update(Article article) {

	}

	@Override
	public void delete(String articleId) {

	}

}
