/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. If the "compressed" string would not become smaller
 * than the original string, you should return the original string
 * EXAMPLE
 * Input: aabcccccaaa
 * Output: a2b1c5a3
 * @author Xiaomin Wei
 *
 */
public class Problem_15 {
	/**
	 * Iterate the input string and keep track the duplicate char
	 * Time: O(N), Space: O(N)
	 * Use StringBuilder instead of String since String in Java is immutable, 
	 * using it will cause O(N + k^2) time
	 * @param input
	 * @return compressed str
	 */
	public static String compressStr(String input) {
		int inputLen = input.length();
		// avoid empty or only one char string
		if (inputLen <= 1) {
			return input;
		}
		
		char[] inputChar = input.toCharArray();
		
		int count = 1;
		StringBuilder res = new StringBuilder();
		res.append(inputChar[0]);
		for (int i = 1; i < inputLen; i++) {
			if (inputChar[i] == inputChar[i - 1]) {
				count++;
			} else {
				res.append(count);
				count = 1;
				res.append(inputChar[i]);
			}
		}
		res.append(count);
		
		if (inputLen < res.length()) {
			return input;
		}
		
		return res.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abccccca";
		System.out.println("Original: " + input);
		System.out.println("Compressed: " + compressStr(input));
	}

}
