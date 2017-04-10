/**
 * 
 */
package baseball.store.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import baseball.domain.BaseballTeam;
import baseball.store.BaseballTeamStore;

/**
 * @author kosta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/WEB-INF/dispatcher-servlet.xml"})
public class BaseballTeamJdbcStoreTest {

	@Autowired
	private BaseballTeamStore store;
	
	@Test
	public void testRetrieve() {
		BaseballTeam team = store.retrieve("1");
		System.out.println(team.getTeamId());
	}

}
