package fleanza.tennis.impl;

import fleanza.tennis.spec.Player;
import fleanza.tennis.spec.Pointboard;
import fleanza.tennis.spec.Scoreboard;

public class Double implements Player {

	private Player	first;
	private Player	second;

	private String	name;

	public Double() {
	}

	@Override
	public String name() {

		if(name == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(first.name());
			sb.append("/");
			sb.append(second.name());
			sb.append("]");
			name = sb.toString();
		}
		return name;
	}

	@Override
	public Pointboard pointboard() {
		return first.pointboard();
	}

	@Override
	public Scoreboard scoreboard() {
		return first.scoreboard();
	}
}
