package baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.domain.BaseballTeam;
import baseball.service.BaseballTeamService;

@Controller
@RequestMapping("team")
public class BaseballTeamController {
	
	@Autowired
	private BaseballTeamService teamService;
	
	@RequestMapping("list.do")
	public String findAllTeams(Model model) {
		List<BaseballTeam> teams = teamService.findAllTeams();
		model.addAttribute("teams", teams);
		
		return "team/teamList";
	}
	
	@RequestMapping("find.do")
	public String findTeam(String teamId, Model model) {
		BaseballTeam team = teamService.findTeam(teamId);
		model.addAttribute("team", team);
		
		return "team/teamDetail";
	}
}
