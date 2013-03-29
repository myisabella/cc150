/**
 * Career Cup 5.3
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
 * @author Xiaomin Wei
 *
 */
public class Problem_53 {
	
	/**
	 * getDigit - get the value at index digit of num
	 * @param num
	 * @param index
	 * @return digit value
	 */
	private int getDigit(int num, int index) {
		// move 1 to index position
		int mask = 1 << index;
		return num & mask;
	}
	
	/**
	 * setDigit - set the digits value to all 0 or 1 based on flag option
	 * @param num
	 * @param index
	 * @param flag
	 */
	private static int setDigit(int num, int index, boolean flag) {
		int mask = (1 << index) - 1;
		
		if (flag) {	// set all bits from 0 to (index - 1) to 1
			num |= mask;
		} else {	// set all bits from 0 to index to 0
			num &= ~mask;
		}
		
		return num;
	}
	
	public static int getNextMax(int num) {
		/* Compute c0 and c1 */
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c0 + c1 == 31 || c0 + c1 == 0)
			return -1;
		
		/* Find the position of rightmost non-trailing zero */
		int p = c0 + c1;
		
		/* Flip the rightmost non-trailing zero */
		num |= (1 << p);
		
		/* Clear all bits to the right of p */
		num = setDigit(num, p, false);
		//num &= ~((1 << p) - 1);
		
		/* Insert (c1 - 1) 1s on the right */
		num = setDigit(num, c1 - 1, true);
		//num |= (1 << (c1 - 1)) - 1;
		
		return num;
	}
	
	public static int getNextMin(int num) {
		/* Compute c0 and c1 */
		int c = num;
		int c0 = 0;
		int c1 = 0;
		
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		if (c == 0)
			return -1;
		
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		
		/* Find the position of rightmost non-trailing zero */
		int p = c0 + c1;
		
		/* Clear all bits from 0 to p */
		num = setDigit(num, p, false);
		
		/* Insert (c1 + 1) 1s to the right of p */
		int mask = (1 << (c1 + 1)) - 1;
		num |= mask << (c0 - 1);
		
		return num;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 13948;
		
		System.out.println("The origin is   " + Integer.toBinaryString(num));
		System.out.println("The next max is " 
				+ Integer.toBinaryString(getNextMax(num)));
		System.out.println("The next min is " 
				+ Integer.toBinaryString(getNextMin(num)));
	}

}
