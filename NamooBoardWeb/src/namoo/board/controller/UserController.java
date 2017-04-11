package namoo.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("login.do")
	public String login(HttpSession session, String inputEmail, String inputPassword) {
		if("1234".equals(inputPassword)) {
			session.setAttribute("id", inputEmail);
			session.setAttribute("name", inputEmail);
		} else {
			throw new RuntimeException("아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "redirect:/board/list.do";
	}
}
