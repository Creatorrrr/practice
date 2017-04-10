package baseball.service;

import java.util.List;

import baseball.domain.BaseballTeam;
import baseball.domain.Player;

/**
 * BaseballTeamService
 * 
 * @author Eunyoung Kim
 */
public interface BaseballTeamService {

	//team
	public BaseballTeam findTeam(String teamId);
	public List<BaseballTeam> findAllTeams();
	public List<BaseballTeam> findAllTeamsWithPlayers();
	public List<BaseballTeam> findTradeTargetPalyers(String teamId);
	
	//player
	public Player findPlayer(String playerId);
	public void tradePlayer(String sourcePlayerId, String targetPlayerId);
	
}
