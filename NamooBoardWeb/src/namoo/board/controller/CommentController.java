package namoo.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import namoo.board.domain.Article;
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
	
	@RequestMapping("regist.ajax")
	@ResponseBody
	public Article registCommentWithAjax(Comment comment, HttpSession session) {
		String id = (String)session.getAttribute("id");
		comment.setAuthorName(id);
		boardService.registerComment(comment);
		
		Article article = boardService.findArticle(comment.getArticleId());
		
		return article;
	}
	
	@RequestMapping("remove.do")
	public String removeComment(Comment comment, HttpSession session) {
		boardService.removeComment(comment.getCommentId());
		
		return "redirect:/article/find.do?articleId=" + comment.getArticleId();
	}
	
	@RequestMapping("remove.ajax")
	@ResponseBody
	public Article removeCommentWithAjax(String articleId, String commentId, HttpSession session) {
		boardService.removeComment(commentId);
		
		Article article = boardService.findArticle(articleId);
		
		return article;
	}
	
}
