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
		if(!val.equals("1") && !val.equals("2")) {
			throw new IllegalArgumentException("Illegal value [" + val + "] on preloaded list. Valid value are: 1 or 2.");
		}

		return val.equals("1") ? RallyResult.create(player1,player2) : RallyResult.create(player2,player1);
	}
}
