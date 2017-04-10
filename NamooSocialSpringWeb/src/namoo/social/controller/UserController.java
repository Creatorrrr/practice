package namoo.social.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import namoo.social.constants.JspConstants;
import namoo.social.entity.User;
import namoo.social.entity.UserToUser;
import namoo.social.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String showLoginForm() {
		return "user/login";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(User user, HttpServletRequest req) {
		if(user == null || 
				user.getId() == null || 
				user.getId().isEmpty() ||
				user.getPassword() == null ||
				user.getPassword().isEmpty()) {
			return "redirect:/user/login.do";
		}
		
		User foundUser = userService.findUserById(user.getId());
		
		if(user.getPassword().equals(foundUser.getPassword())) {
			req.getSession().setAttribute("loginedUser", foundUser);
			return "redirect:/message/myMessage.do";
		} else {
			return "redirect:/user/login.do";
		}
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/user/login.do";
	}
	
	@RequestMapping(value="join.do", method=RequestMethod.GET)
	public String showJoinForm() {
		return "user/join";
	}
	
	@RequestMapping(value="join.do", method=RequestMethod.POST)
	public String join(User user) {
		if(!userService.registerUser(user)) {
			throw new RuntimeException("회원 가입에 실패했습니다.");
		} else {
			return "user/login";
		}
	}
	
	@RequestMapping(value="following.do", method=RequestMethod.GET)
	public String showFollowingList(Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<User> users = userService.findUsersByFromIdWithoutSelf(loginedUser.getId());
		model.addAttribute("users", users);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "user/followingList";
	}
	
	@RequestMapping(value="following.do", method=RequestMethod.POST)
	public String showFollowingListWithSearch(String keyword, Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<User> users = userService.findUsersByFromIdWithoutSelf(loginedUser.getId(), keyword);
		model.addAttribute("users", users);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "user/followingList";
	}
	
	@RequestMapping(value="follower.do", method=RequestMethod.GET)
	public String showFollowerList(Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<User> users = userService.findUsersByToUserWithoutSelf(loginedUser.getId());
		model.addAttribute("users", users);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "user/followerList";
	}
	
	@RequestMapping(value="follower.do", method=RequestMethod.POST)
	public String showFollowerListWithSearch(String keyword, Model model, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		List<User> users = userService.findUsersByToUserWithoutSelf(loginedUser.getId(), keyword);
		model.addAttribute("users", users);
		Repeater.addMainNavAttributes(userService, loginedUser, model);	// add main navigation's attributes instead
		return "user/followerList";
	}
	
	@RequestMapping(value="unfollow.do", method=RequestMethod.GET)
	public String unfollow(String toUserId, HttpServletRequest req) {
		User loginedUser = (User)req.getSession().getAttribute(JspConstants.LOGINED_USER);
		if(loginedUser == null) {
			return "redirect:/user/login.do";
		}
		UserToUser utu = new UserToUser();
		utu.setFromUser(loginedUser);
		User toUser = new User();
		toUser.setId(toUserId);
		utu.setToUser(toUser);
		if(!userService.removeUserToUser(utu)) {
			throw new RuntimeException("언팔로우에 실패하였습니다.");
		} else {
			return "redirect:/user/following.do";
		}
	}
}
