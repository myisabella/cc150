/**
 * Bloomberg LP Interview Question - There are N gas stations positioned along
 * a circular road. Each has a limited supply of gas. You can only drive
 * clockwise around the road. You start with zero gas. Knowing how much gas you
 * need to get from each gas station to the next and how much gas you can get at
 * each station, design an algorithm to find the gas station you need to start 
 * at to get all the way around the circle.
 * 
 * Algorithm - Maximum Consecutive Subsequence
 * @author Xiaomin Wei
 *
 */
public class circularGas {
	/**
	 * findGasStation - using Maximum Consecutive Subsequence algorithm
	 * make a array that contains from gas station #0 ~ #n-1 ~ #1
	 * total number is 2*n - 1, then find MCS from this array which satisfy
	 * gas-dist is always bigger than 0 
	 * O(n) worst case
	 * 
	 * @param gas
	 * @param dist
	 * @return start gas station number
	 */
	public static int findGasStation(int[] gas, int[] dist) {
		int i;
		int delta = 0;
		int count = 0;
		int num = gas.length;
		
		if (num <= 0 || num != dist.length) {
			System.err.println("Invalid Input");
			return Integer.MIN_VALUE;
		}
		
		for (i = 0; i < 2 * num - 1; i++) {
			delta += gas[i % num] - dist[i % num];
			
			// Check if can start from this gas station
			if (delta < 0) {
				delta = 0;
				count = 0;
				continue;
			}
			
			// update count
			count++;
			
			// check if loop all gas stations
			if (num == count)
				//break;
				return i - count + 1;
		}
		/*
		if (num == count)
			return i - count + 1;
		else
		*/
			return Integer.MIN_VALUE;
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {4, 4, 3, 2, 5};
		int[] dist = {1, 2, 3, 4, 5};
		
		int k = findGasStation(gas, dist);
		if (k != Integer.MIN_VALUE)
			System.out.println("start from " + k);
		else
			System.out.println("No soln");
	}

}
