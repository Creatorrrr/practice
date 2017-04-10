package baseball.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baseball.domain.Player;
import baseball.store.PlayerStore;
import baseball.store.mapper.PlayerMapper;

@Repository
public class PlayerJdbcStore implements PlayerStore {

	@Autowired
	private SqlSession session;

	@Override
	public void update(Player player) {
		PlayerMapper mapper = session.getMapper(PlayerMapper.class);
		mapper.updatePlayer(player);
	}

	@Override
	public Player retrieve(String playerId) {
		PlayerMapper mapper = session.getMapper(PlayerMapper.class);
		Player player = mapper.selectPlayerById(playerId);
		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		PlayerMapper mapper = session.getMapper(PlayerMapper.class);
		List<Player> players = mapper.selectPlayersByTeamId(teamId);
		return players;
	}

}
