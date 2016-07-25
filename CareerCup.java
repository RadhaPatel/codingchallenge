public class CareerCup{
	public static void main(String[] args){

	}

	/* 
		Find the longest Palindrome - Palindrome the same forwards and backwards
	*/
	public static String longestPalindrome(String str){
		if(str == null || str.length <= 1){
			return str; 
		}
		if(isPalidrome(str)){
			return str; 
		}
		else{
			
		}
	}

	// Is the given string a palidorme
	public static boolean isPalidorme(String s){
		int i = 0; 
		int j = s.length() - 1; 
		while(i < j){
			if(s.charAt(i) != (s.charAt(j))){
				return false; 
			}
			else{
				i++; 
				j--; 
			}
		}
		return true; 
	}
}