import java.util.*; 

public class Chapter1{
	public static void main(String[] args){
		//testIsOneAway(); 
		//testCompress(); 
		//testZeroMatrix(); 

	}

	public static void testIsOneAway(){
		System.out.println( isOneAway("pale", "ple")); 
		System.out.println( isOneAway("pales", "pale")); 
		System.out.println( isOneAway("pale", "bale")); 
		System.out.println( isOneAway("pale", "bake")); 
		System.out.println( isOneAway("apple", "abble")); 
		System.out.println( isOneAway("apple", "abble")); 
	}
/*
One Away: There are 3 types of edits that can be preformed on strings: insert, remove, and replace a char. Given 2 strings, write a function
to check if they are one efir (or zero edits) away; 
*/
	public static boolean isOneAway(String s1, String s2){
		HashMap<Character, Integer> h1 = new HashMap<Character, Integer>(); 

		for(char c : s1.toCharArray()){
			if(!h1.containsKey(c)){
				h1.put(c, 1); 
			} 
			else{
				h1.put(c, h1.get(c) + 1);  
			}
		}

		int deletion = 0; 
		int insertion = 0; 
		int replace = 0; 
		
		for(char c: s2.toCharArray()){
			//HashMap does not have a char in the string
			if(!h1.containsKey(c)){
				if(h1.size() == s2.length()){
					replace++;
				}
				else if(Math.abs(h1.size() - s2.length()) == 1){
					deletion++; 
					insertion++; 
				}
			}
		}
		// HashMap has a char not in the string
		for(Character c: h1.keySet()){
			if(!s2.contains( c.toString())) {
				if(Math.abs(h1.size() - s2.length()) == 1){
					deletion++; 
					insertion++; 
				}
			}
		}

		return (deletion == 1 || insertion == 1 || replace == 1);
	}

	public static void testCompress(){
		System.out.println( compress("aaab")); 
		System.out.println( compress("aaabbbbccc")); 
	}

	/*
		Compress: Given a string compess it: aaabbbccc -> a3b3c3
	*/ 
	public static String compress(String str){
		// aaab --> a3b3c3
		int counter = 0; 
		StringBuffer s1 = new StringBuffer(); 
		
		for(int i = 0; i < str.length(); i++){
			counter++; 

			if( i+1 >= str.length() || str.charAt(i + 1) != str.charAt(i)){
				s1.append(str.charAt(i)); 
				s1.append(counter); 
				counter = 0;	
			}
		}
		String compressed = s1.toString(); 
		return (compressed.length() < str.length() ? compressed : str); 
	}

	public static void testZeroMatrix(){
		int[][] arr = new int[][]{
		  { 9, 4, 0},
		  { 3, 6, 1 },
		  { 1, 2, 8 },
		  { 5, 3, 7 },
		  { 4, 3, 9 }
		};  
		printMatrix(zeroMatrix(arr)); 

	}	

	public static void printMatrix(int[][] arr){
		for(int i = 0; i < arr.length;i++){
			for(int j = 0; j < arr[0].length; j++){
				System.out.print(" " + arr[i][j] + " "); 
			}
			System.out.println(); 
		}
		System.out.println(); 
	}

	/*
		Zero Matrix: if an element in an MxN matrix is zero then the entire row and column is zero 
	*/
	public static int[][] zeroMatrix(int[][] matrix){
		int[][] copy = copyMatrix(matrix); 
		for(int r = 0; r < matrix.length; r++){
			for(int c = 0; c < matrix[0].length; c++){
				if(matrix[r][c] == 0){
					changeRC(r, c, copy); 
					printMatrix(copy); 
				}
			}
		}
		return copy; 
	}

	public static void changeRC(int r, int c, int[][]arr){
		for(int i = 0; i < arr.length; i++){
			arr[i][c] = 0; 
		}
		for(int j = 0; j < arr[0].length; j++){
			arr[r][j] = 0; 
		}
	}

	public static int[][] copyMatrix(int[][] arr){
		int[][] newMatrix = new int [arr.length][arr[0].length]; 
		for(int i = 0; i < arr.length;i++){
			for(int j = 0; j < arr[0].length; j++){
				newMatrix[i][j] = arr[i][j]; 
			}
		}
		return newMatrix; 
	}


}