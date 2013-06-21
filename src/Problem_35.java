/**
 * Implement a MyQueue class which implements a queue using two stacks
 * Queue is FIFO while stack is FILO. Let use s1 to be the ordered with the
 * newest elements on the top, while s2 will have the oldest elements on the 
 * top. Push new elements onto s1, and peek and pop from s2. When s2 is empty,
 * transfer all the elements from s2 onto s2 in reverse order.
 */

import java.util.*;

public class Problem_35<T> {
	Stack<T> s1, s2;
	public Problem_35() {
		s1 = new Stack<T> ();
		s2 = new Stack<T> ();
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public void add(T value) {
		s1.push(value);
	}

	public T remove() {
		if (!s2.isEmpty()) {
			return s2.pop();
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		return s2.pop();
	}

	public T peek() {
		if (!s2.isEmpty()) {
			return s2.peek();
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		return s2.peek();
	}
}