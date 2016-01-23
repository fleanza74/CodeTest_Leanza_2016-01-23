package fleanza.tennis.impl;

import fleanza.tennis.spec.Player;
import fleanza.tennis.spec.Pointboard;
import fleanza.tennis.spec.Scoreboard;

public class Single implements Player {

	private String			name;
	private Pointboard	pointboard;
	private Scoreboard	scoreboard;

	public Single(String aName) {

		if(aName == null) {
			throw new NullPointerException("Name param NULL");
		}

		if(aName.trim().isEmpty()) {
			throw new IllegalArgumentException("Name param EMPTY");
		}

		name = aName;
		pointboard = new Pointboard();
		scoreboard = new Scoreboard();
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Pointboard pointboard() {
		return pointboard;
	}

	@Override
	public Scoreboard scoreboard() {
		return scoreboard;
	}
}
