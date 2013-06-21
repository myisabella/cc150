/**
 * Given two strings write a method to decide if one is a permutation 
 * of the other
 * @author Xiaomin Wei
 *
 */

import java.util.*;

public class Problem_13 {
	/**
	 * First sort two string then use built-in equals function to compare
	 * @param s
	 * @return
	 */
	private static String sort(String s) {
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())	return false;
		
		return sort(s1).equals(sort(s2));
	}
	
	/**
	 * Suppose all characters in string are ASCII, use bitmap
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isPermutation2(String s1, String s2) {
		if (s1.length() != s2.length())	return false;
		
		int[] ascii = new int[128];
		
		/* Loop s1, add 1 on each character meet */
		for (int i = 0, len = s1.length(); i < len; i++) {
			ascii[s1.charAt(i)]++;
		}
		
		/* Loop s1, sub 1 on each character meet */
		for (int i = 0, len = s2.length(); i < len; i++) {
			ascii[s2.charAt(i)]--;
		}
		
		/* Loop ascii to check if all zero */
		for (int i = 0, len = ascii.length; i < len; i++) {
			if (ascii[i] != 0) return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aAb";
		String s2 = "aab";
		
		System.out.println(s1 + " and " + s2 + " is permutable? "
						+ isPermutation2(s1, s2));
	}

}
