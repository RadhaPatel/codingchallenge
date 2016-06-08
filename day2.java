public class day2 {
	public static void main(String[] arg){
		int[][] matrix = { {1, 2}, {3, 4} };
		printMatrix(matrix);  
		System.out.println(rotate(matrix)); 
		printMatrix(matrix); 
		
	}

	/* 
	Problem 2: Given an image represented by an NxN matrix, where each pixel in the 
	image is 4 bytes, write a method to rotate the image by 90 degrees
	Can you do this in place? 
	*/

	public static boolean rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false; 
		int len = matrix.length; 
		for(int i = 0; i < len / 2; i++){
			int first = i; 
			int last = len - 1 - i; 
			for(int j = first; j < last; j++){
				int offset = j - first; 

				// Swap 
				int top = matrix[first][j]; 
				// top <- left
				matrix[first][j] = matrix[last - offset][first]; 
				// left <- bottom
				matrix[last - offset][first] = matrix[last][last - offset]; 
				// bottom <- right
				matrix[last][last - offset] = matrix[j][last]; 
				// right <- top
				matrix[j][last] = top; 

			}
		}
		return true; 
	}

	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " "); 
			}
			System.out.println(); 
		}
	}
}	
