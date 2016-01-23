package fleanza.tennis.spec;

import fleanza.tennis.impl.Single;

public class GameEngine {

	public GameEngine() {
	}

	public static void refresh(Player p1, Player p2) {

		if(p1.pointboard().point().intValue() == p2.pointboard().point().intValue()) {
			refreshEq(p1,p2);
		}
		else {
			refreshNotEq(p1,p2);
		}
		printScore(p1,p2);
	}

	private static void refreshEq(Player p1, Player p2) {

		if(p1.pointboard().point().intValue() == 0) {
			p1.scoreboard().push(Score.LOVE);
			p2.scoreboard().push(Score.LOVE);
		}
		else if(p1.pointboard().point().intValue() == 1) {
			p1.scoreboard().push(Score.FIFTEEN);
			p2.scoreboard().push(Score.FIFTEEN);
		}
		else if(p1.pointboard().point().intValue() == 2) {
			p1.scoreboard().push(Score.THIRTY);
			p2.scoreboard().push(Score.THIRTY);
		}
		else {
			p1.scoreboard().push(Score.DEUCE);
			p2.scoreboard().push(Score.DEUCE);
		}
	}

	private static void refreshNotEq(Player p1, Player p2) {

		if(p1.pointboard().point().intValue() > 3 || p2.pointboard().point().intValue() > 3) {
			refreshModeExtra(p1,p2);
		}
		else {
			refreshModeNormal(p1,p2);
		}
	}

	private static void refreshModeExtra(Player p1, Player p2) {

		int dist = p1.pointboard().point().intValue() - p2.pointboard().point().intValue();
		int abs = Math.abs(dist);

		if(abs == 1) {
			refreshAdv(p1,p2,dist);
		}
		else {
			refreshWin(p1,p2,dist);
		}
	}

	private static void refreshAdv(Player p1, Player p2, int dist) {

		if(dist > 0) {
			p1.scoreboard().push(Score.ADVANTAGE);
			p2.scoreboard().push(Score.HANDICAP);
		}
		else {
			p1.scoreboard().push(Score.HANDICAP);
			p2.scoreboard().push(Score.ADVANTAGE);
		}
	}

	private static void refreshWin(Player p1, Player p2, int dist) {

		if(dist > 0) {
			if(dist >= 2) {
				p1.scoreboard().push(Score.WIN);
				p2.scoreboard().push(p2.scoreboard().score());
			}
			else {
				p1.scoreboard().push(Score.WIN);
				p2.scoreboard().push(Score.HANDICAP);
			}
		}
		else {
			if(dist <= -2) {
				p1.scoreboard().push(p1.scoreboard().score());
				p2.scoreboard().push(Score.WIN);
			}
			else {
				p1.scoreboard().push(Score.HANDICAP);
				p2.scoreboard().push(Score.WIN);
			}
		}
	}

	private static void refreshModeNormal(Player p1, Player p2) {
		refreshNormalScore(p1);
		refreshNormalScore(p2);
	}

	private static void refreshNormalScore(Player p) {

		if(p.pointboard().point().intValue() == 0) {
			p.scoreboard().push(Score.LOVE);
		}
		else if(p.pointboard().point().intValue() == 1) {
			p.scoreboard().push(Score.FIFTEEN);
		}
		else if(p.pointboard().point().intValue() == 2) {
			p.scoreboard().push(Score.THIRTY);
		}
		else {
			p.scoreboard().push(Score.FORTY);
		}
	}

	public static void printScore(Player player1, Player player2) {
		System.out.format("%15s | %15s%n",player1.scoreboard().score().name(),player2.scoreboard().score().name());

	}

	public static void main(String[] args) {

		Player p1 = new Single("Francesco");
		Player p2 = new Single("Adry");

		System.out.println("GAME 1 -------------------------");
		GameEngine.test(p1,p2,0,0);
		GameEngine.test(p1,p2,0,1);
		GameEngine.test(p1,p2,0,2);
		GameEngine.test(p1,p2,1,2);
		GameEngine.test(p1,p2,1,3);
		GameEngine.test(p1,p2,2,3);
		GameEngine.test(p1,p2,2,4);
		System.out.println("--------------------------------");

		p1 = new Single("Francesco");
		p2 = new Single("Adry");

		System.out.println();
		System.out.println("GAME 2 -------------------------");
		GameEngine.test(p1,p2,0,0);
		GameEngine.test(p1,p2,1,1);
		GameEngine.test(p1,p2,2,1);
		GameEngine.test(p1,p2,2,2);
		GameEngine.test(p1,p2,2,3);
		GameEngine.test(p1,p2,3,3);
		GameEngine.test(p1,p2,4,3);
		GameEngine.test(p1,p2,4,4);
		GameEngine.test(p1,p2,5,4);
		GameEngine.test(p1,p2,5,5);
		GameEngine.test(p1,p2,5,6);
		GameEngine.test(p1,p2,6,6);
		GameEngine.test(p1,p2,7,6);
		GameEngine.test(p1,p2,8,6);
		System.out.println("--------------------------------");

		System.exit(0);
	}

	private static void test(Player p1, Player p2, int s1, int s2) {

		if(s1 == s2 && s1 == 0) {
			printScore(p1,p2);
			return;
		}

		if(p1.pointboard().point().intValue() == s1) {
			p1.pointboard().keep();
		}
		else {
			p1.pointboard().improve();
		}

		if(p2.pointboard().point().intValue() == s2) {
			p2.pointboard().keep();
		}
		else {
			p2.pointboard().improve();
		}

		GameEngine.refresh(p1,p2);
	}
}
