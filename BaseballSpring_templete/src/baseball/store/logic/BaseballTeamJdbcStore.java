package baseball.store.logic;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baseball.domain.BaseballTeam;
import baseball.store.BaseballTeamStore;
import baseball.store.mapper.BaseballTeamMapper;

@Repository
public class BaseballTeamJdbcStore implements BaseballTeamStore {
	
	@Autowired
	private SqlSession session;

	@Override
	public BaseballTeam retrieve(String teamId) {
		BaseballTeamMapper mapper = session.getMapper(BaseballTeamMapper.class);
		BaseballTeam team = mapper.selectBaseballTeamById(teamId);
		return team;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		BaseballTeamMapper mapper = session.getMapper(BaseballTeamMapper.class);
		List<BaseballTeam> teams = mapper.selectAllBaseballTeams();
		return teams;
	}

}
