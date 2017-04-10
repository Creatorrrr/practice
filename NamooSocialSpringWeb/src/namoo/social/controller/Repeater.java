package namoo.social.controller;

import org.springframework.ui.Model;

import namoo.social.entity.User;
import namoo.social.service.UserService;

public class Repeater {
	public static void addMainNavAttributes(UserService userService, User loginedUser, Model model) {
		model.addAttribute("followingCount", userService.numberOfRelatedUsersByFromUser(loginedUser.getId()));
		model.addAttribute("followerCount", userService.numberOfRelatedUsersByToUser(loginedUser.getId()));
	}
}
