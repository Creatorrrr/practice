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

import namoo.board.domain.Board;
import namoo.board.store.BoardStore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("dispatcher-servlet.xml")
public class BoardStoreLogicTest {
	
	@Autowired
	private BoardStore boardStore;
	
	@Test
	public void testCreate() {
		Board board = new Board();
		board.setCreatedDate(new Date(Calendar.getInstance().getTimeInMillis()));
		board.setCreatorName("1234");
		board.setName("2345");
		
		boardStore.create(board);
		
		System.out.println(board.getBoardId());
	}
	
	@Test
	public void testRetrieve() {
		Board board = boardStore.retrieve("1");
		
		assertEquals("1", board.getBoardId());
	}
	
	@Test
    public void testUpdate() {
		Board board = new Board();
		board.setBoardId("1");
		board.setCreatedDate(new Date((long)1));
		board.setCreatorName("2222");
		board.setName("ffff");
		
		boardStore.update(board);
		
		Board result = boardStore.retrieve("1");
		
		assertEquals("2222", result.getCreatorName());
	}
	
	@Test
    public void testDelete() {
		boardStore.delete("1");
		Board board = boardStore.retrieve("1");
		
		assertNull(board);
	}
	
	@Test
	public void testRetrieveAll() {
		List<Board> boards = boardStore.retrieveAll();
		
		assertEquals(4, boards.size());
	}
}
