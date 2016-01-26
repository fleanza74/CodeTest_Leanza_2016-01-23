package fleanza.tennis.spec;

import java.util.HashMap;
import java.util.Map;

public class ScoreboardHandler {

	private Map<Player,Scoreboard> map;

	public ScoreboardHandler(Player player1, Player player2) {
		map = new HashMap<Player,Scoreboard>(0);
		map.put(player1,new Scoreboard());
		map.put(player2,new Scoreboard());
	}

	public Scoreboard scoreboardOf(Player player) {
		return map.get(player);
	}
}
