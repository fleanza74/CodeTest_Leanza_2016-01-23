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

		boolean flag = random.nextBoolean();

		if(flag) {
			player1.pointboard().improve();
			player2.pointboard().keep();
			return RallyResult.create(player1,player2);
		}
		else {
			player1.pointboard().keep();
			player2.pointboard().improve();
			return RallyResult.create(player2,player1);
		}
	}
}
