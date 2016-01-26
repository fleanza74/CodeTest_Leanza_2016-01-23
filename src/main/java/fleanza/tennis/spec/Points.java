package fleanza.tennis.spec;

import java.util.EmptyStackException;
import java.util.Stack;

public class Points {

	private Stack<Integer> stack;

	public Points() {
		stack = new Stack<Integer>();
		stack.push(Integer.valueOf(0));
	}

	/**
	 * Pushes a <code>Value</code> onto the top of pointboard increasing by one
	 * the last <code>Value</code>.
	 *
	 * @return the next <code>Value</code>.
	 */
	public Integer increment() {
		return stack.push(Integer.valueOf(stack.peek().intValue() + 1));
	}

	/**
	 * Pushes a <code>Value</code> onto the top of pointboard pushing the same
	 * value the last <code>Value</code>.
	 *
	 * @return the next <code>Value</code>.
	 */
	public Integer keep() {
		return stack.push(Integer.valueOf(stack.peek().intValue()));
	}

	/**
	 * Looks at the <code>Value</code> on top of pointboard without removing it
	 * from the pointboard.
	 *
	 * @return the <code>Value</code> on top of pointboard.
	 * @throws EmptyStackException
	 *           if the pointboard is empty.
	 */
	public Integer peek() {
		return stack.peek();
	}
}
