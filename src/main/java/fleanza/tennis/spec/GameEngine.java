package fleanza.tennis.spec;

public class GameEngine {

	public GameEngine() {
	}

	public void refresh(Scoreboard spw, Scoreboard spl) {

		spw.getPoints().increment();
		spl.getPoints().keep();

		if(spw.getPoints().peek().intValue() == spl.getPoints().peek().intValue()) {
			refreshEq(spw,spl);
		}
		else {
			refreshNotEq(spw,spl);
		}
	}

	private void refreshEq(Scoreboard spw, Scoreboard spl) {

		if(spw.getPoints().peek().intValue() == 0) {
			spw.getScores().push(Score.LOVE);
			spl.getScores().push(Score.LOVE);
		}
		else if(spw.getPoints().peek().intValue() == 1) {
			spw.getScores().push(Score.FIFTEEN);
			spl.getScores().push(Score.FIFTEEN);
		}
		else if(spw.getPoints().peek().intValue() == 2) {
			spw.getScores().push(Score.THIRTY);
			spl.getScores().push(Score.THIRTY);
		}
		else {
			spw.getScores().push(Score.DEUCE);
			spl.getScores().push(Score.DEUCE);
		}
	}

	private void refreshNotEq(Scoreboard spw, Scoreboard spl) {

		if(spw.getPoints().peek().intValue() > 3 || spl.getPoints().peek().intValue() > 3) {
			refreshAdvOrWin(spw,spl);
		}
		else {
			refreshNormal(spw,spl);
		}
	}

	private void refreshAdvOrWin(Scoreboard spw, Scoreboard spl) {

		int dist = spw.getPoints().peek().intValue() - spl.getPoints().peek().intValue();
		int abs = Math.abs(dist);

		if(abs == 1) {
			refreshAdv(spw,spl,dist);
		}
		else {
			refreshWin(spw,spl,dist);
		}
	}

	private void refreshAdv(Scoreboard spw, Scoreboard spl, int dist) {

		if(dist > 0) {
			spw.getScores().push(Score.ADVANTAGE);
			spl.getScores().push(Score.HANDICAP);
		}
		else {
			spw.getScores().push(Score.HANDICAP);
			spl.getScores().push(Score.ADVANTAGE);
		}
	}

	private void refreshWin(Scoreboard spw, Scoreboard spl, int dist) {

		if(dist > 0) {
			if(dist >= 2) {
				spw.getScores().push(Score.WIN);
				spl.getScores().push(spl.getScores().peek());
			}
			else {
				spw.getScores().push(Score.WIN);
				spl.getScores().push(Score.HANDICAP);
			}
		}
		else {
			if(dist <= -2) {
				spw.getScores().push(spw.getScores().peek());
				spl.getScores().push(Score.WIN);
			}
			else {
				spw.getScores().push(Score.HANDICAP);
				spl.getScores().push(Score.WIN);
			}
		}
	}

	private void refreshNormal(Scoreboard spw, Scoreboard spl) {
		refreshNormal(spw);
		refreshNormal(spl);
	}

	private void refreshNormal(Scoreboard sb) {

		if(sb.getPoints().peek().intValue() == 0) {
			sb.getScores().push(Score.LOVE);
		}
		else if(sb.getPoints().peek().intValue() == 1) {
			sb.getScores().push(Score.FIFTEEN);
		}
		else if(sb.getPoints().peek().intValue() == 2) {
			sb.getScores().push(Score.THIRTY);
		}
		else {
			sb.getScores().push(Score.FORTY);
		}
	}
}
