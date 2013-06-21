/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list. Suppose in k = 1 would return the last element.
 * @author Xiaomin Wei
 *
 */

public class Problem_22 {
	public class IntWrapper{
		public int val = 0;
	}
	
	/**
	 * Recursive way to find kth to last node. 
	 * Since cannot return both node and counter, we create a wrapper class to
	 * hold the value of counter because Object in Java is immutable, we can
	 * update its value in this function.
	 * @param head
	 * @param k
	 * @param i
	 * @return
	 */
	public static LinkedListNode kthToLastRecursive(LinkedListNode head, int k,
													IntWrapper i) {
		// avoid empty linked list case
		if (head == null) {
			return null;
		}
		
		LinkedListNode node = kthToLastRecursive(head.next, k, i);
		i.val = i.val + 1;
		
		if (i.val == k) {
			return head;
		}
		
		return node;
	}
	
	/**
	 * Iterative method to find kth element to last node. we create 2 node and
	 * place them k nodes apart; then we move them at the same speed; when the
	 * later one hit the end of linked list, the first one would be the kth 
	 * node to the last node.
	 * Time: O(N), Space: O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public static LinkedListNode kthToLastIterative(LinkedListNode head, int k) {
		// avoid empty linked list case
		if (head == null) {
			return null;
		}
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null;
			}
			p1 = p1.next;
		}
		
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
