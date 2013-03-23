/**
 * Career Cup 5.2 - Given a real number between 0 and 1 (e.g., 0.72) that is 
 * passed in as a double, print the binary representation. If the number 
 * cannot be represented accurately in binary with at most 32 characters, print
 * "ERROR".
 * 
 * @author myisabella
 *
 */
public class Problem_52 {
  	/**
	 * printBinary - print binary representation of a real number
	 * @param input
	 * @return output
	 */
	public static String printBinary(double input) {
		if (input <= 0 || input >= 1)
			return "ERROR";
		
		// initialize output as '0.'
		StringBuilder output = new StringBuilder();
		output.append(0);
		output.append(".");
		
		double base = 0.5;
		while (input > 0) {
			if (output.length() > 32) 
				return "ERROR"; 
			
			if (input >= base) {
				output.append(1);
				input -= base;
			} else {
				output.append(0);
			}
			
			// update base value;
			base /= 2;
		}
		
		return output.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double num = Double.parseDouble(args[0]);
		System.out.println("The binary representation of " + num
				+ " is " + printBinary(num));
	}

}
