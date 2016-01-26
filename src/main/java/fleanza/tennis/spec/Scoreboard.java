package fleanza.tennis.spec;

/**
 * @author fleanza
 */
public class Scoreboard {

	private Points points;
	private Scores scores;

	public Scoreboard() {
		points = new Points();
		scores = new Scores();
	}

	public Points getPoints() {
		return points;
	}

	public Scores getScores() {
		return scores;
	}
}
