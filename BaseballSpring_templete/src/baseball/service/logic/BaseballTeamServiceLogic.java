package baseball.service.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baseball.domain.BaseballTeam;
import baseball.domain.Player;
import baseball.service.BaseballTeamService;
import baseball.store.BaseballTeamStore;
import baseball.store.PlayerStore;

@Service
public class BaseballTeamServiceLogic implements BaseballTeamService {

	@Autowired
	private BaseballTeamStore teamStore;
	@Autowired
	private PlayerStore playerStore;
	
	@Override
	public BaseballTeam findTeam(String teamId) {	
		BaseballTeam team = teamStore.retrieve(teamId);
		
		if(team == null) {
			return null;
		} else {
			List<Player> players = playerStore.retrieveByTeam(teamId);
			team.setPlayers(players);
			return team;
		}
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return teamStore.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		List<BaseballTeam> teams = teamStore.retrieveAll();
		for(BaseballTeam team : teams) {
			List<Player> players = playerStore.retrieveByTeam(team.getTeamId());
			team.setPlayers(players);
		}
		return teams;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		List<BaseballTeam> teams = teamStore.retrieveAll();
		List<BaseballTeam> targetTeams = new ArrayList<>();
		
		for(BaseballTeam team : teams) {
			if(!team.getTeamId().equals(teamId)) {
				targetTeams.add(team);
			}
		}
		
		for(BaseballTeam team : targetTeams) {
			List<Player> players = playerStore.retrieveByTeam(team.getTeamId());
			team.setPlayers(players);
		}
		
		return targetTeams;
	}

	@Override
	public Player findPlayer(String playerId) {
		return playerStore.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		Player sourcePlayer = playerStore.retrieve(sourcePlayerId);
		Player targetPlayer = playerStore.retrieve(targetPlayerId);
		
		String sourceTeamId = sourcePlayer.getTeamId();
		sourcePlayer.setTeamId(targetPlayer.getTeamId());
		targetPlayer.setTeamId(sourceTeamId);
		
		playerStore.update(sourcePlayer);
		playerStore.update(targetPlayer);
	}
	
}
