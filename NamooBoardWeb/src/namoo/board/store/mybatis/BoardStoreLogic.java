package namoo.board.store.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import namoo.board.domain.Board;
import namoo.board.store.BoardStore;
import namoo.board.store.mybatis.mapper.BoardMapper;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override
	public String create(Board board) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.create(board);
		session.close();
		
		// 생성된 sequence를 반환해야 한다.
		return board.getBoardId();
	}

	@Override
	public Board retrieve(String boardId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board board = mapper.retrieve(boardId);
		session.close();
		
		return board;
	}

	@Override
	public void update(Board board) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		mapper.update(board);
		session.close();
	}

	@Override
	public void delete(String boardId) {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		mapper.delete(boardId);
		session.close();
	}

	@Override
	public List<Board> retrieveAll() {
		SqlSession session = NamooBoardSessionFactory.getInstance().getSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		List<Board> boards = mapper.retrieveAll();
		session.close();
		
		return boards;
	}

}
