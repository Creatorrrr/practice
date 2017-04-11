package namoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import namoo.board.domain.Board;
import namoo.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("list.do")
	public String findAllBoards(Model model) {
		List<Board> boards = boardService.findAllBoards();
		
		model.addAttribute("boards", boards);
		
		return "article/articleMain";
	}
	
	@RequestMapping("find.do")
	public String findBoard(String boardId, Model model) {
		Board board = boardService.findBoard(boardId);
		model.addAttribute("boardDetail", board);
		
		List<Board> boards = boardService.findAllBoards();
		model.addAttribute("boards", boards);
		
		return "article/articleList";
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.GET)
	public String registBoard(Model model) {
		List<Board> boards = boardService.findAllBoards();
		model.addAttribute("boards", boards);
		
		return "board/boardCreate";
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.POST)
	public String registBoard(Board board, HttpSession session) {
		board.setCreatorName((String)session.getAttribute("id"));
		boardService.registerBoard(board);
		
		return "redirect:/board/mgntList.do";
	}
	
	@RequestMapping("mgntList.do")
	public String findAllBoardsForMgnt(Model model) {
		List<Board> boards = boardService.findAllBoards();
		model.addAttribute("boards", boards);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.GET)
	public String modifyBoard(String boardId, Model model) {
		Board board = boardService.findBoard(boardId);
		List<Board> boards = boardService.findAllBoards();
		
		model.addAttribute("boardDetail", board);
		model.addAttribute("boards", boards);
		
		return "board/boardModify";
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public String modifyBoard(Board board) {
		boardService.modifyBoard(board);
		
		return "redirect:/board/modify.do?boardId=" + board.getBoardId();
	}
	
	@RequestMapping("remove.do")
	public String removeBoard(String boardId) {
		boardService.removeBoard(boardId);
		
		return "redirect:/board/mgntList.do";
	}
}
