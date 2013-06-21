/**
 * Write an algorithm s.t if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 * @author Xiaomin Wei
 *
 */
public class Problem_17 {
	public static void setZeros(int[][] matrix) {
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		boolean[] row = new boolean[rowNum];
		boolean[] col = new boolean[colNum];
		
		// loop to find row num and col num of zero element
		for (int i = 0; i < rowNum; i++) {
			if (!row[i]) {
				for (int j = 0; j < colNum; j++) {
					if (!col[j]) {
						if (matrix[i][j] == 0) {
							row[i] = true;
							col[j] = true;
						}
					}
				}
			}
			
		}
		
		// loop again to set zeros
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1,2,3},{4,0,6},{7,8,9}};
		setZeros(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

}
