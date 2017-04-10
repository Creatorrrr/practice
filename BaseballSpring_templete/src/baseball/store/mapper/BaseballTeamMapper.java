package baseball.store.mapper;

import java.util.List;

import baseball.domain.BaseballTeam;

public interface BaseballTeamMapper {
	public BaseballTeam selectBaseballTeamById(String id);
	public List<BaseballTeam> selectAllBaseballTeams();
}
