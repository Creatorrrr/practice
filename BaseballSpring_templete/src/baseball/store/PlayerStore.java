package baseball.store;

import java.util.List;

import baseball.domain.Player;

/**
 * PlayerStore
 * 
 */
public interface PlayerStore {

	public void update(Player player);
	public Player retrieve(String playerId);
	public List<Player> retrieveByTeam(String teamId);
}
