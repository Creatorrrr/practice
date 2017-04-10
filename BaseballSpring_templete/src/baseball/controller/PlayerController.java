package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.domain.BaseballTeam;
import baseball.domain.Player;
import baseball.service.BaseballTeamService;

@Controller
@RequestMapping("player")
public class PlayerController {

	@Autowired
	private BaseballTeamService teamService;
	
	@RequestMapping("list.do")
	public String findPlayersByTeam(String teamId, Model model) {
		BaseballTeam team = teamService.findTeam(teamId);
		
		List<BaseballTeam> teams = new ArrayList<>();
		teams.add(team);
		
		int allPlayersCount = 0;
		
		if(team.getPlayers() != null) {
			allPlayersCount = team.getPlayers().size();
		}
		
		model.addAttribute("teams", teams);
		model.addAttribute("allPlayersCount", allPlayersCount);
		
		return "player/playerList";
	}
	
	@RequestMapping("allList.do")
	public String findAllPlayers(Model model) {
		List<BaseballTeam> teams = teamService.findAllTeamsWithPlayers();
		
		int allPlayersCount = 0;
		
		for(BaseballTeam team : teams) {
			allPlayersCount += team.getPlayers().size();
		}
		
		model.addAttribute("teams", teams);
		model.addAttribute("allPlayersCount", allPlayersCount);
		
		return "player/playerList";
	}
	
	@RequestMapping("tradeTargetList.do")
	public String findTradeTargerPlayers(Player player, Model model) {
		List<BaseballTeam> teams = teamService.findTradeTargetPalyers(player.getTeamId());
		
		Player tradePlayer = teamService.findPlayer(player.getPlayerId());
		
		int allPlayersCount = 0;
		
		for(BaseballTeam team : teams) {
			allPlayersCount += team.getPlayers().size();
		}
		
		model.addAttribute("teams", teams);
		model.addAttribute("tradePlayer", tradePlayer);
		model.addAttribute("allPlayersCount", allPlayersCount);
		
		return "player/tradeTargetList";
	}
	
	@RequestMapping("trade.do")
	public String trade(String sourcePlayerId, String targetPlayerId) {
		teamService.tradePlayer(sourcePlayerId, targetPlayerId);
		return "redirect:/player/allList.do";
	}
}
