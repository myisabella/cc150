/**
 * Implement an algorithm to delete a node in the middle of a singly linked 
 * list, given only access to that node.
 * @author Xiaomin Wei
 *
 */
public class Problem_23 {
	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		
		LinkedListNode next = n.next;
		n.val = next.val;
		n.next = next.next;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
