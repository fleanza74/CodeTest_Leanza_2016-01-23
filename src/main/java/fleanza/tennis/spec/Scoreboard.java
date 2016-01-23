package fleanza.tennis.spec;

import java.util.EmptyStackException;
import java.util.Stack;

public class Scoreboard {

	private Stack<Score> stack;

	public Scoreboard() {
		stack = new Stack<Score>();
		stack.push(Score.LOVE);
	}

	/**
	 * Looks at the <code>Score</code> on top of scoreboard without removing it
	 * from the scoreboard.
	 *
	 * @return the <code>Score</code> on top of scoreboard.
	 * @throws EmptyStackException
	 *           if the scoreboard is empty.
	 */
	public Score score() {
		return stack.peek();
	}

	/**
	 * Return the <code>Score</code> on top of scoreboard and remove it from the
	 * scoreboard.
	 *
	 * @return The <code>Score</code> on top of scoreboard.
	 * @throws EmptyStackException
	 *           if scoreboard is empty.
	 */
	public Score pop() {
		return stack.pop();
	}

	/**
	 * Pushes a <code>Score</code> onto the top of scoreboard.
	 *
	 * @param score
	 *          the <code>Score</code> to be pushed onto scoreboard.
	 * @return the <code>Score</code> argument.
	 */
	public Score push(Score score) {
		return stack.push(score);
	}
}
