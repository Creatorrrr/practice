package baseball.store;

import java.util.List;

import baseball.domain.BaseballTeam;


/**
 * BaseballTeamStore
 * 
 */
public interface BaseballTeamStore {

	public BaseballTeam retrieve(String teamId);
	public List<BaseballTeam> retrieveAll();
}
