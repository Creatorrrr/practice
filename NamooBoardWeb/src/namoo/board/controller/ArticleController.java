package namoo.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import namoo.board.domain.Article;
import namoo.board.domain.Board;
import namoo.board.service.BoardService;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="regist.do", method=RequestMethod.GET)
	public String registArticle(String boardId, Model model) {
		List<Board> boards = boardService.findAllBoards();
		Board boardDetail = boardService.findBoard(boardId);
		
		model.addAttribute("boards", boards);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("boardId", boardId);
		
		return "article/articleWrite";
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.POST)
	public String registArticle(Article article, HttpSession session) {
		article.setAuthorName((String)session.getAttribute("name"));
		boardService.registerArticle(article);
		
		return "redirect:/board/find.do?boardId=" + article.getBoardId();
	}
	
	@RequestMapping("find.do")
	public String findArticle(String articleId, Model model) {
		Article article = boardService.findArticle(articleId);
		model.addAttribute("article", article);
		
		Board boardDetail = boardService.findBoard(article.getBoardId());
		model.addAttribute("boardDetail", boardDetail);
		
		List<Board> boards = boardService.findAllBoards();
		model.addAttribute("boards", boards);
		
		return "article/articleDetailWithCommentAjax";
	}
	
	@RequestMapping("remove.do")
	public String removeArticle(String articleId, String boardId) {
		boardService.removeArticle(articleId);
		
		return "redirect:/board/find.do?boardId=" + boardId;
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.GET)
	public String modifyArticle(String articleId, String boardId, Model model) {
		Article article = boardService.findArticle(articleId);
		model.addAttribute("article", article);
		
		Board boardDetail = boardService.findBoard(boardId);
		model.addAttribute("boardDetail", boardDetail);
		
		List<Board> boards = boardService.findAllBoards();
		model.addAttribute("boards", boards);
		
		return "article/articleModify";
	}
	
	@RequestMapping(value="modify.do", method=RequestMethod.POST)
	public String modifyArticle(Article article) {
		boardService.modifyArticle(article);
		
		return "redirect:/article/find.do?articleId=" + article.getArticleId();
	}
}
