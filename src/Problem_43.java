/**
 * Given a sorted (increasing order) array, write an algorithm to create a 
 * binary search tree with minimal height.
 * @author Xiaomin Wei
 *
 */
import java.util.*;

public class Problem_43 {
	public static TreeNode createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		
		return n;
	}
	
	public static TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}
	
	public static ArrayList<Integer> traverseBST(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		traverseBSTHelper(root, res);
		return res;
	}
	
	public static void traverseBSTHelper(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		}
		
		traverseBSTHelper(root.left, res);
		res.add(root.val);
		traverseBSTHelper(root.right, res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[11];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		TreeNode root = createMinimalBST(array);
		ArrayList<Integer> result = traverseBST(root);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.printf("%d\t", result.get(i));
		}
		System.out.println();
	}

}
