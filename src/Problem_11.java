/**
 * Implement an algorithm to determine if a string has all unique characters.
 * @author Xiaomin Wei
 *
 */

import java.util.*;

public class Problem_11 {
	/**
	 * Suppose all characters in String is ASCII so that we can build a boolean
	 * array to act like HashMap to find duplicate
	 * @param s
	 * @return is unique or not
	 */
	public static boolean isUniqueChars1(String s) {
		if (s.length() > 256)	return false;
		
		boolean[] char_set = new boolean[256];
		for (int i = 0, strLen = s.length(); i < strLen; i++) {
			int val = s.charAt(i);
			
			/* Check if this char is already in string */
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	/**
	 * Suppose there are other characters than ASCII, use HashMap
	 * @param s
	 * @return is unique or not
	 */
	public static boolean isUniqueChars2(String s) {
		HashMap<Character, Character> hmap = new HashMap<Character, Character>();
		for (int i = 0, strLen = s.length(); i < strLen; i++) {
			if (hmap.containsKey(s.charAt(i))) {
				return false;
			}
			
			hmap.put(s.charAt(i), s.charAt(i));
		}
		
		return true;
		
	}
	
	/**
	 * Suppose we must do in space (a.k.a O(1)) and all characters in string
	 * are lower-case letters from a to z
	 * @param s
	 * @return is unique or not
	 */
	public static boolean isUniqueChars3(String s) {
		if (s.length() > 256)	return false;
		
		int checker = 0;	// bit vector
		
		for (int i = 0, strLen = s.length(); i < strLen; i++) {
			int val = s.charAt(i) - 'a';
			
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			
			checker |= (1 << val);
		}
		
		return true;
	}
	
	/**
	 * First sort the characters in string then compare
	 * Time: O(NlogN), Space: O(N)
	 * @param s
	 * @return
	 */
	public static boolean isUniqueChars4(String s) {
		char[] char_set = s.toCharArray();
		Arrays.sort(char_set);
		
		for (int i = 0; i < char_set.length - 1; i++) {
			if (char_set[i] == char_set[i + 1])
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abA";
		System.out.println("\"" + str + "\" " + "is unique char? " 
						+ isUniqueChars4(str));		
	}

}
