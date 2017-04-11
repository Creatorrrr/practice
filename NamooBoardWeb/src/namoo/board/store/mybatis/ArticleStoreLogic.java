package namoo.board.store.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import namoo.board.domain.Article;
import namoo.board.store.ArticleStore;
import namoo.board.store.mybatis.mapper.ArticleMapper;

@Repository
public class ArticleStoreLogic implements ArticleStore {

	@Override
	public String create(Article article) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.create(article);
		session.close();
		
		// 생성된 sequence를 반환해야 한다. 
		return article.getArticleId();
	}

	@Override
	public Article retrieve(String articleId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		Article article = mapper.retrieve(articleId);
		session.close();
		
		return article;
	}

	@Override
	public List<Article> retrieveAll(String boardId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		List<Article> articles = mapper.retrieveAll(boardId);
		session.close();
		
		return articles;
	}

	@Override
	public void update(Article article) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.update(article);
		session.close();
	}

	@Override
	public void delete(String articleId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		
		mapper.delete(articleId);
		session.close();
	}

}
