package namoo.board.store.mybatis.mapper;

import java.util.List;

import namoo.board.domain.Board;


public interface BoardMapper {

    int create(Board board);
    Board retrieve(String boardId);
    void update(Board board);
    void delete(String boardId);
	List<Board> retrieveAll();
}
