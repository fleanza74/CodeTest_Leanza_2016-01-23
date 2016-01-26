package fleanza.tennis.impl;

import java.util.Random;

import fleanza.tennis.spec.Player;
import fleanza.tennis.spec.Rally;
import fleanza.tennis.spec.RallyResult;

public class RandomRally implements Rally {

	private Random random;

	public RandomRally() {
		random = new Random();
	}

	@Override
	public RallyResult play(Player player1, Player player2) {
		return random.nextBoolean() ? RallyResult.create(player1,player2) : RallyResult.create(player2,player1);
	}
}
