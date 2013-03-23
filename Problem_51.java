/**
 * Career Cup 5.1 You are given two 32-bit numbers, N and M, and two bit
 * positions, i and j. Write a method to insert M into N such that M starts at
 * bit j and ends at i.
 * 
 * @author myisabella
 * 
 */
public class Problem_51 {
	/**
	 * bitMask - Generate a mask consisting of all 1's from lowbit to highbit
	 * 
	 * @param highbit
	 * @param lowbit
	 * @return mask
	 */
	public static int bitMask(int highbit, int lowbit) {
		int negOne = ~0;
		int highPart = (negOne << highbit) << 1;
		int lowPart = negOne << lowbit;

		return (highPart ^ lowPart) & lowPart;
	}

	public static void main(String[] args) {
		int N = 1024;
		int M = 19;
		int i = 2; // low bit
		int j = 6; // high bit

		//Integer result = new Integer((N & (~bitMask(j, i))) | (M << i));
		int result = (N & (~bitMask(j, i))) | (M << i);

		System.out.println("The result is " + Integer.toBinaryString(result));
	}
}
