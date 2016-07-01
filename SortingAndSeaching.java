public class SortingAndSearching{
	/*
		10.1 Sorted Merge: Given 2 sorted arrays - where A has enough room to hold B merge the 2 in sorted order.
	*/
	public void sortedMerge(int[] a, int[] b, int lastA, int lastB){
		int indexA = lastA - 1; 
		int indexB = lastB - 1; 
		int currentIndex = lastA + lastB - 1; 

		while(indexB >= 0){
			if(indexA >= 0 && a[indexA] >= b[indexB]){
				a[currentIndex] = a[indexA]; 
				indexA--; 
			} 
			else{
				a[currentIndex] = b[indexB]; 
				indexB--; 
			}
			currentIndex--; 
		}
	}

	/* 
		10.2 Group Anagrams: Sort an array of strings so that all the anagrams are next to each other...
	*/
	class AnagramComparator implements Comparator<String> {
		public String sortChars(String s){
			char[] chars = s.toCharArray(); 
			Arrays.sort(chars); 
			return new String(chars); 
		}

		public int compare(String s1, String s2){
			return sortChars(s1).compareTo(sortChars(s2)); 
		}
	}

	public void sortAnagrams(String[] anagrams){

		HashMap<String, List<String> map = new HashMap<String, List<String>>(); 

		for(String s: anagrams){
			String sorted_key = sortChars(s); 
			if(!map.contains(key)){
				List<String> values = new List<String>(); 
				values.add(s); 
				map.put(key, values); 
			} 
			else{
				map.get(key).add(s); 
			}
		}

		int index = 0; 
		for(String key: map.keySet()){
			List<Sting> list = map.get(key); 
			for(String ans: list){
				anagrams[index] = ans; 
				index++; 
			}
		}
	}
}