/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring.
 * EXAMPLE
 * "waterbottle" is a rotation of "erbottlewat"
 * @author Xiaomin Wei
 *
 */
public class Problem_18 {
	public static boolean isSubstring(String sum, String part) {
		return sum.contains(part);
	}
	
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		/**
		 * Use string concatenation to find if rotation
		 */
		String sum = s1 + s2;
		return isSubstring(sum, s2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "apple";
		String s2 = "pplea";
		
		System.out.println(isRotation(s1, s2));
	}

}
