package namoo.board.store.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import namoo.board.domain.Article;
import namoo.board.store.ArticleStore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"dispatcher-servlet.xml"})
public class ArticleStoreLogicTest {
	
	@Autowired
	private ArticleStore articleStore;
	
	@Test
	public void testCreate() {
		Article article = new Article();
		article.setAuthorName("1234");
		article.setTitle("2345");
		article.setContents("3456");
		article.setRegDate(new Date(Calendar.getInstance().getTimeInMillis()));
		article.setBoardId("2");
		
		articleStore.create(article);
	}
	
	@Test
	public void testRetrieve() {
		Article article = articleStore.retrieve("3");
		
		assertEquals("1234", article.getAuthorName());
	}
	
	@Test
	public void testRetrieveAll() {
		List<Article> articles = articleStore.retrieveAll("2");
		
		assertEquals(2, articles.size());
	}
	
	@Test
	public void testUpdate() {
		Article article = new Article();
		article.setArticleId("3");
		article.setAuthorName("4444");
		article.setTitle("322");
		article.setContents("333");
		article.setRegDate(new Date(Calendar.getInstance().getTimeInMillis()));
		article.setBoardId("2");
		articleStore.update(article);
		
		Article updated = articleStore.retrieve("3");
		
		assertEquals("4444", updated.getAuthorName());
	}
	
	@Test
	public void testDelete() {
		articleStore.delete("3");
		
		Article article = articleStore.retrieve("3");
		
		assertNull(article);
	}
}
