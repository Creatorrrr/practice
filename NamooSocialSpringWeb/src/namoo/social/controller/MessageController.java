package namoo.social.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import namoo.social.constants.JspConstants;
import namoo.social.entity.Message;
import namoo.social.entity.User;
import namoo.social.service.MessageService;
import namoo.social.service.UserService;

@Controller
@RequestMapping("message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/myMessage.do", method=RequestMethod.GET)
	public String showMyMessage(Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<Message> messages = messageService.findMessagesByWriterId(loginedUser.getId());
		model.addAttribute("messages", messages);
		model.addAttribute("sender", JspConstants.MESSAGE_MY);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "message/messageList";
	}
	
	@RequestMapping(value="/newestMessage.do", method=RequestMethod.GET)
	public String showNewestMessage(Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<Message> messages = messageService.findNewestMessagesByWriterId(loginedUser.getId());
		model.addAttribute("messages", messages);
		model.addAttribute("sender", JspConstants.MESSAGE_NEWEST);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "message/messageList";
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public String createMyMessage(Message message, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		message.setWriterId(loginedUser.getId());
		message.setRegistDate(new Date(System.currentTimeMillis()));
		if(!messageService.registerMessage(message)) {
			throw new RuntimeException("메시지 등록에 실패했습니다.");
		} else {
			return "redirect:/message/myMessage.do";
		}
	}
}
