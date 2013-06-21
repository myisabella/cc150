/**
 * Given an image represented by an NxN matrix, where each pixel in the image
 * is 4 bytes, write a method to rotate the image by 90 degrees (in place).
 * @author Xiaomin Wei
 *
 */
public class Problem_16 {
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n/2; ++layer) {
			int first = layer;
			int last = n - layer - 1;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int n = 3;
		rotate(matrix, n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

}
