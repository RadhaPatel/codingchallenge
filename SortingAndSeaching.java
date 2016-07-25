public class SortingAndSeaching{

	// /*
	// 	10.1 Sorted Merge: Given 2 sorted arrays - where A has enough room to hold B merge the 2 in sorted order.
	// */
	// public void sortedMerge(int[] a, int[] b, int lastA, int lastB){
	// 	int indexA = lastA - 1; 
	// 	int indexB = lastB - 1; 
	// 	int currentIndex = lastA + lastB - 1; 

	// 	while(indexB >= 0){
	// 		if(indexA >= 0 && a[indexA] >= b[indexB]){
	// 			a[currentIndex] = a[indexA]; 
	// 			indexA--; 
	// 		} 
	// 		else{
	// 			a[currentIndex] = b[indexB]; 
	// 			indexB--; 
	// 		}
	// 		currentIndex--; 
	// 	}
	// }

	// /* 
	// 	10.2 Group Anagrams: Sort an array of strings so that all the anagrams are next to each other...
	// */
	// class AnagramComparator implements Comparator<String> {
	// 	public String sortChars(String s){
	// 		char[] chars = s.toCharArray(); 
	// 		Arrays.sort(chars); 
	// 		return new String(chars); 
	// 	}

	// 	public int compare(String s1, String s2){
	// 		return sortChars(s1).compareTo(sortChars(s2)); 
	// 	}
	// }

	// public void sortAnagrams(String[] anagrams){

	// 	HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 

	// 	for(String s: anagrams){
	// 		String sorted_key = sortChars(s); 
	// 		if(!map.contains(key)){
	// 			List<String> values = new List<String>(); 
	// 			values.add(s); 
	// 			map.put(key, values); 
	// 		} 
	// 		else{
	// 			map.get(key).add(s); 
	// 		}
	// 	}

	// 	int index = 0; 
	// 	for(String key: map.keySet()){
	// 		List<Sting> list = map.get(key); 
	// 		for(String ans: list){
	// 			anagrams[index] = ans; 
	// 			index++; 
	// 		}
	// 	}
	// }

	// /*
	// 	10.3 Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an 
	// 	element in the array. 
	// */
	// public int searchRotated(int[] arr, int left, int right, int x){
	// 	int middle = (left + right) /2 ; 
	// 	if(arr[middle] == x){
	// 		return middle; 
	// 	}
	// 	if(left > right){
	// 		return -1; 
	// 	}
	// 	if(arr[left] < arr[middle]){
	// 		if(x <= arr[middle] && x >= arr[left]){
	// 			return searchRotated(arr, left, middle - 1, x); 
	// 		} 
	// 		else{
	// 			return searchRotated(arr, middle + 1, right, x); 
	// 		}
	// 	} 
	// 	else if(arr[left] > arr[middle]){
	// 		if(x > a[middle] && x < a[right]){
	// 			return searchRotated(arr, middle + 1, right, x); 
	// 		} 
	// 		else {
	// 			return searchRotated(arr, left, middle - 1, x); 
	// 		}
	// 	}
	// 	else if( arr[left] == arr[middle]){
	// 		if(arr[right] != arr[middle]){
	// 			return searchRotated(arr, middle + 1, right, x); 
	// 		}
	// 	}
	// 	else{
	// 		int result = searchRotated(arr, left, middle -1, x); 
	// 		if(result == -1){
	// 			return searchRotated(arr, middle + 1, rigth, x); 
	// 		}
	// 		return result; 
	// 	}
	// }

	// /*
	// 	10.4 Sorted Search, No Size: 
	// */
	// public in sortedListy(Listy a, int x){
	// 	int index = 1; 
	// 	while(a.elementAt(index) != -1 && a.elementAt(index) < x){
	// 		index *= 2; 
	// 	}
	// 	return binarySearch(a, index/2, index, x); 
	// }

	// /*
	// 	10.5 Sparse Search: Given a sorted array of strings that is interspersed with empty strings,
	// 	 wrtie a method to find the location of a given string

	// 	 METHOD: if middle is empty search for next closest empty string
	// */
	// public int sortedStrings(Strings[]strings, String str){
	// 	sortedStrings(strings, str, 0, strings.length()); 
	// }
	// public int sortedStrings(String[] strings, String str, int start, int end){
	// 	if(start > end)
	// 		return -1; 

	// 	int mid = (start + last) / 2;

	// 	if(strings[mid] == ""){
	// 		// Find closest none empty string to be the middle
	// 		int left = mid - 1; 
	// 		int right = mid + 1; 
	// 		while(left > first && right < last){
	// 			if(strings[left] != ""){
	// 				mid = left; 
	// 				break; 
	// 			}
	// 			else if(strings[right] != ""){
	// 				mid = right; 
	// 				break; 
	// 			}
	// 			right--; 
	// 			left--; 
	// 		}
	// 	}

	// 	String midStr = strings[mid]; 
	// 	// str is equal
	// 	if(str.compareTo(midStr) == 0 ){
	// 		return mid; 
	// 	}
	// 	// str is smaller than middle 
	// 	else if(str.compareTo(midStr) < 0 ){
	// 		return sortedStrings(strings, str, first, mid - 1); 
	// 	}
	// 	else{
	// 		return sortedStrings(strings, str, mid + 1, last); 
	// 	}
	// }


	/*
		Given an array of numbers and a sum eturn a pair that equals to the sum
	*/
		public static int[] findSumPair(int[] arr, int sum){
			int[] res = new int[2]; 
			mergeSort(arr); 
			int left = 0; 
			int right = arr.length - 1; 
			while(arr[left] < arr[right]){
				if(arr[right] - arr[left] < sum){
					left++; 
				}
				else if(arr[right] - arr[left] > sum){
					right--; 
				}
				else{
					res[0] = arr[left]; 
					res[1] = arr[right]; 
					return res; 
				}
			}
			return null; 
		}

		public static void mergeSort(int[] arr){
			int[] helper = new int[arr.length]; 
			mergeHelper(arr, helper, 0, arr.length); 
		}

		public static void mergeHelper(int[] arr, int[] helper, int low, int high){
			if(low < high){
				int middle = (low + high) / 2; 
				merge(arr, helper, 0, middle, high); 
			}
		}

		public static void merge(int[] arr, int[] helper, int low, int middle, int high){
			for(int i = low; i < high; i++){
				helper[i] = arr[i]; 
			}

			int left = low; 
			int right = middle + 1;
			int current = low; 

			while(low <= middle && right <= high){
				if(helper[left] < helper[right]){
					arr[current] = helper[left]; 
					current++; 
					left++; 
				}
				else{
					arr[current] = helper[right]; 
					current++; 
					right++; 
				}
			} 

			int rest = middle - left; 
			for(int i = 0; i < rest; i++){
				arr[current + i] = helper[left + i]; 
			}
		}


		public static void main(String[] args){
			int sum = 10; 
			int[] arr = {1, 2, 4, 5, 9, 7, 6}; 
			int[] res = findSumPair(arr, sum); 
			if(res != null){
				System.out.println(res[0] + " " + res[1]); 
			}
			else{
				System.out.println("No Pair Exists"); 
			}
		}
















}