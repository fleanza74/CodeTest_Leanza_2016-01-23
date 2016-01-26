package fleanza.tennis.spec;

/**
 * @author fleanza
 */
public class RallyResult {

	private Player winner;
	private Player loser;

	public RallyResult(Player aWinner, Player aLoser) {

		if(aWinner == null) {
			throw new NullPointerException("winner param NULL");
		}

		if(aLoser == null) {
			throw new NullPointerException("loser param NULL");
		}

		winner = aWinner;
		loser = aLoser;
	}

	public static RallyResult create(Player aWinner, Player aLoser) {
		return new RallyResult(aWinner,aLoser);
	}

	public Player winner() {
		return winner;
	}

	public Player loser() {
		return loser;
	}
}
