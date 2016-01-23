package fleanza.tennis.spec;

import fleanza.tennis.impl.RandomRally;
import fleanza.tennis.impl.Single;

public class Game {

	private Player	player1;
	private Player	player2;
	private Rally		rally;

	public Game(Player aPlayer1, Player aPlayer2, Rally aRally) {
		player1 = aPlayer1;
		player2 = aPlayer2;
		rally = aRally;
	}

	public static Game create(Player aPlayer1, Player aPlayer2, Rally aRally) {
		return new Game(aPlayer1,aPlayer2,aRally);
	}

	public void play() {

		System.out.format("Start Game ...%n%n");
		System.out.format("%15s | %15s%n","Adriana","Francesco");
		System.out.format("%33s%n", "---------------------------------");

		RallyResult result;
		boolean existWinner = false;
		GameEngine.printScore(player1,player2);
		do {
			result = rally.play(player1,player2);
			GameEngine.refresh(player1,player2);
			existWinner = result.winner().scoreboard().score().equals(Score.WIN) ? true : false;
		}
		while(!existWinner);
		
		System.out.format("%33s%n%n", "---------------------------------");
		System.out.format("*** %5s WIN!!! ***%n%n", result.winner().name());
		System.out.format("End Game%n%n");
	}

	public static void main(String[] args) {		
		try {
			Player p1 = new Single("Francesco");
			Player p2 = new Single("Adry");
			Rally r = new RandomRally();
			// Rally r = new PreloadRally("01100110");
			Game g = Game.create(p1,p2,r);
			g.play();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
