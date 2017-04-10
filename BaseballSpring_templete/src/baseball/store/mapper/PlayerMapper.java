package baseball.store.mapper;

import java.util.List;

import baseball.domain.Player;

public interface PlayerMapper {
	public int updatePlayer(Player player);
	public Player selectPlayerById(String playerId);
	public List<Player> selectPlayersByTeamId(String teamId);
}
