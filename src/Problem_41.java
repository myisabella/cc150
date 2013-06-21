/**
 * Implement a function to check if a binary tree is balanced. A balanced tree
 * is defined to be a tree s.t the heights of the two subtrees of any node 
 * never differs by more than one.
 * 
 * Method 1: Simple but not efficient. For each node, we do getHeight and 
 * isBalanced, which leads to Time: O(N^2)
 * Method 2: Check if balanced while compute the height
 * Time: O(N), Space: O(logN)
 * @author Xiaomin Wei
 *
 */
public class Problem_41 {
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (heightDiff > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	/**
	 * Use -1 to denote the unbalanced case
	 * @param root
	 * @return
	 */
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		
		// ! Remember to add 1 on the height
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public static boolean isBalanced2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
