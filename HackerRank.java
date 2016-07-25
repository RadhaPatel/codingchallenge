import java.util.Scanner;

public class HackerRank{
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Scanner sc = new Scanner(System.in); 
        // int n = sc.nextInt(); 
        // int d = sc.nextInt(); 
        // int[] arr = new int[n]; 
        // for(int i = 0; i < n; i++){
        //     arr[i] = sc.nextInt(); 
        // }
        int[] arr = {1, 2, 3, 4, 5}; 
        int d = 3;  
        //leftRotatebyOne(arr,d); 
        leftRotatebyOne(arr, arr.length, d); 
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " "); 
        }
    }

	public static void rotateLeft(int[] arr, int d){
        int prev = arr[0]; 
        while(d > 0){
            for(int i = arr.length-1; i <= 0; i--){
                prev = arr[i-1]; 
                arr[i - 1] = arr[i]; 
            }
            arr[arr.length-1] = prev; 
            d--; 
        }
    }

    public static void leftRotatebyOne(int arr[], int n, int d) 
    {
    	while(d < 0){
    		int i, temp;
       		temp = arr[0];
        	for (i = 0; i < n - 1; i++){
        		arr[i] = arr[i + 1];
        	}
        	arr[i] = temp;
    		d--; 
    	}
    }
}