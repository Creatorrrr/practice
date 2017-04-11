package namoo.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import namoo.board.domain.Comment;
import namoo.board.service.BoardService;

@Controller
@RequestMapping("comment")
public class CommentController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("regist.do")
	public String registComment(Comment comment, HttpSession session) {
		comment.setAuthorName((String)session.getAttribute("name"));
		boardService.registerComment(comment);
		
		return "redirect:/article/find.do?articleId=" + comment.getArticleId();
	}
	
	@RequestMapping("remove.do")
	public String removeComment(Comment comment, HttpSession session) {
		boardService.removeComment(comment.getCommentId());
		
		return "redirect:/article/find.do?articleId=" + comment.getArticleId();
	}
	
}
