package fleanza.tennis.spec;

import fleanza.tennis.client.AnsiElement;
import fleanza.tennis.client.AnsiOutput;

public class Game {

	private Player player1;
	private Player player2;
	private Rally rally;
	private ScoreboardHandler handler;
	private GameEngine engine;

	public Game(Player aPlayer1, Player aPlayer2, Rally aRally) {

		if(aPlayer1 == null) {
			throw new NullPointerException("Player1 NULL");
		}

		if(aPlayer2 == null) {
			throw new NullPointerException("Player2 NULL");
		}

		if(aRally == null) {
			throw new NullPointerException("Rally NULL");
		}

		player1 = aPlayer1;
		player2 = aPlayer2;
		rally = aRally;
		handler = new ScoreboardHandler(player1,player2);
		engine = new GameEngine();
	}

	public static Game create(Player aPlayer1, Player aPlayer2, Rally aRally) {
		return new Game(aPlayer1,aPlayer2,aRally);
	}

	public void play() {

		System.out.format("Start Game ...%n%n");
		System.out.format("%15s | %15s%n",player1.getName(),player2.getName());
		System.out.format("%33s%n","---------------------------------");
		print();

		boolean existWinner = false;
		RallyResult result;
		do {
			result = rally.play(player1,player2);
			Scoreboard spw = refresh(result);
			print();
			existWinner = spw.getScores().peek().equals(Score.WIN) ? true : false;
		}
		while(!existWinner);

		System.out.format("%33s%n%n","---------------------------------");
		System.out.println(AnsiOutput.toString(AnsiElement.GREEN,String.format("*** %5s WIN!!! ***%n%n",result.winner().getName())));
		//System.out.format("*** %5s WIN!!! ***%n%n",result.winner().getName());
		System.out.format("End Game%n%n");
	}

	private Scoreboard refresh(RallyResult result) {
		Scoreboard spw = handler.scoreboardOf(result.winner());
		Scoreboard spl = handler.scoreboardOf(result.loser());
		engine.refresh(spw,spl);
		return spw;
	}

	private void print() {
		Scoreboard sp1 = handler.scoreboardOf(player1);
		Scoreboard sp2 = handler.scoreboardOf(player2);
		System.out.format("%15s | %15s%n",sp1.getScores().peek().name(),sp2.getScores().peek().name());
	}
}
