/**
 * Given a range, find the max prime number in this range
 * @author Xiaomin Wei
 *
 */
public class MaxPrimeNum {
	/**
	 * findMaxPrime
	 * @param lo - lower bound of the range
	 * @param hi - upper bound of the range
	 * 
	 * 1) loop from hi to lo will save time since we're looking for max prime
	 * 2) using sqrt(hi) as a divider (cast sqrt value to int)
	 */
	public static void findMaxPrime(int lo, int hi) {
		// check input is valid or not
		if (lo <= 0 || hi <= 0 || hi < lo) {
			System.err.println("Invalid input");
			return;
		}
		
		int sqrtHi = (int) Math.sqrt(hi) + 1;
		
		for (int i = hi; i >= lo; --i) {
			boolean isPrime = true;
			
			for (int div = 2; div < sqrtHi; ++div) {
				if (i % div == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				System.out.println("The max prime number is " + i);
				return;
			}
		}
		
		System.out.println("No such prime number");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMaxPrime(1, 665536);
	}

}
