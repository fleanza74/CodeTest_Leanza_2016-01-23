package fleanza.tennis.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import fleanza.tennis.spec.Player;
import fleanza.tennis.spec.Rally;
import fleanza.tennis.spec.RallyResult;

public class PreloadRally implements Rally {

	private Queue<String> fifo;

	public PreloadRally(String values) {

		if(values == null) {
			throw new NullPointerException("Values param NULL");
		}

		if(values.trim().length() == 0) {
			throw new IllegalArgumentException("Values param EMPTY");
		}

		fifo = new LinkedList<String>(Arrays.asList(values.split("")));
	}

	@Override
	public RallyResult play(Player player1, Player player2) {

		if(fifo.isEmpty()) {
			throw new RuntimeException("Rallies ended. The game end not properly.");
		}

		String val = fifo.poll();
		if(val.equals("1")) {
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
