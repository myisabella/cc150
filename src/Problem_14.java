import java.util.Arrays;

/**
 * Write a method to replace all spaces in a string with '%20'. 
 * EXAMPLE
 * Input: "Mr John Smith   "
 * Output: "Mr%20John%20Smith"
 * @author Xiaomin Wei
 *
 */
public class Problem_14 {
	/**
	 * Use StringBuilder to do it, also multiple spaces only count once
	 * Time: O(N), Space: O(N)
	 * @param input
	 * @return
	 */
	public static String replaceStr1(String input) {
		StringBuilder res = new StringBuilder();
		input = input.trim();
		int inputLen = input.length();
		char[] inputChar = input.toCharArray();
		
		res.append(inputChar[0]);
		for (int i = 1; i < inputLen; i++) {
			if (inputChar[i] == ' ' && inputChar[i] != inputChar[i-1]) {
				res.append("%20");
			} else if (inputChar[i] != ' '){
				res.append(inputChar[i]);
			}
		}
		
		return res.toString();
	}
	
	//TODO: in-place implementation not working
	/**
	 * In-place method
	 * @param input
	 */
	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0;
		int i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		int newLength = length + 2 * spaceCount;
		//str = Arrays.copyOf(str, newLength + 1);
		//System.out.println(str);
		char[] sp = new char[2*spaceCount];
		for (char c : sp) {
			c = ' ';
		}
		String temp = str.toString();
		temp = temp + new String(new char[2*spaceCount]);
		str = temp.toCharArray();
		//str[newLength] = '\0';
		
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			} else {
				str[newLength - 1] = str[i];
				newLength -= 1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Mr  John Smith   ";
		System.out.println(input);
		System.out.println("Method 1: " + replaceStr1(input));
		char[] str = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ',
						' ', ' ', ' ', ' ', ' '};
		int len = str.length;
		System.out.println("len: " + len);
		replaceSpaces(str, len);
		System.out.println("Method 2: " + str);
	}

}
