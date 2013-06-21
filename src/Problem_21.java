/**
 * Write code to remove duplicates from an unsorted linked list
 * FOLLOW UP
 * solve it if temporary buffer is not allowed
 * @author Xiaomin Wei
 *
 */

import java.util.*;

public class Problem_21 {
	/**
	 * Use hashtable to check if there is duplicate; if so, then remove it by
	 * skipping this node and put prev.next to its next;
	 * Time: O(N), Space: O(N)
	 * @param n
	 */
	public static void removeDups1(LinkedListNode n) {
		Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean> ();
		LinkedListNode prev = null;
		
		while (n != null) {
			if (ht.contains(n.val)) {
				prev.next = n.next;
			} else {
				ht.put(n.val, true);
				prev = n;
			}
			
			n = n.next;
		}
	}
	
	/**
	 * Use two pointer (fast and slow) to find duplicate
	 * Time: O(N^2), Space: O(1)
	 * @param n
	 */
	public static void removeDups2(LinkedListNode n) {
		if (n == null) {
			return;
		}
		
		LinkedListNode cur = n;
		while (cur != null) {
			LinkedListNode runner = cur;
			while (runner.next != null) {
				if (cur.val == runner.next.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
