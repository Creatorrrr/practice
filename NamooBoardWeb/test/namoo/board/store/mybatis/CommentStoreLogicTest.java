package namoo.board.store.mybatis;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import namoo.board.domain.Comment;
import namoo.board.store.CommentStore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:WebContent/WEB-INF/dispatcher-servlet.xml"})
public class CommentStoreLogicTest {
	
	@Autowired
	private CommentStore commentStore;
	
//	@Test
//	public void testCreate() {
//		Comment comment = new Comment();
//		comment.setAuthorName("1234");
//		comment.setComment("2345");
//		comment.setRegDate(new Date(Calendar.getInstance().getTimeInMillis()));
//		comment.setArticleId("4");
//		
//		commentStore.create(comment);
//	}
//	
	@Test
	public void retrieveAll() {
		List<Comment> comments = commentStore.retrieveAll("4");
		
		assertEquals(0, comments.size());
	}
//	
//	@Test
//	public void delete() {
//		commentStore.delete("1");
//		
//		List<Comment> comments = commentStore.retrieveAll("4");
//		
//		assertEquals(3, comments.size());
//	}
}
