/**
 * Given a binary tree, design an algorithm which creates a linked list of all 
 * the nodes at each depth
 * @author Xiaomin Wei
 *
 */

import java.util.*;

public class Problem_44 {
	public static void createLevelLinkedList(TreeNode root, 
			ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		if (list.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
