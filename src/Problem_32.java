/**
 * Design a stack which, in addition to push and pop, also has a function min
 * which returns the minimum element. Push, pop and min should all operate in
 * O(1) time.
 */

import java.util.*;

public class Problem_32 extends Stack<Integer> {
	public Stack<Integer> minStack;
	public Problem_32() {
		minStack = new Stack<Integer>();
	}

	public void push(int value) {
		if (value < min()) {
			minStack.push(value);
		}

		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			minStack.pop();
		}

		return value;
	}

	public int min() {
		if (minStack.isEmpty()) {	// Error case: no element in minStack
			return Integer.MAX_VALUE;
		} else {
			// peek only return the top element of a stack w/o pop it
			return minStack.peek();
		}
	}
}