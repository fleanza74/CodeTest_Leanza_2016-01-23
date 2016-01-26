package fleanza.tennis.spec;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author fleanza
 */
public class Scores {

	private Stack<Score> stack;

	public Scores() {
		stack = new Stack<Score>();
		stack.push(Score.LOVE);
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

	/**
	 * Return the <code>Score</code> on top of scoreboard and remove it from the
	 * scoreboard.
	 *
	 * @return The <code>Score</code> on top of scoreboard.
	 * @throws EmptyStackException
	 *           if scoreboard is empty.
	 */
	public Score pull() {
		return stack.pop();
	}

	/**
	 * Looks at the <code>Score</code> on top of scoreboard without removing it
	 * from the scoreboard.
	 *
	 * @return the <code>Score</code> on top of scoreboard.
	 * @throws EmptyStackException
	 *           if the scoreboard is empty.
	 */
	public Score peek() {
		return stack.peek();
	}
}
