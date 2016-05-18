import java.util.*; 

public class day1
{

	 /*
	 	Problem 1: From a given string of words, get the top n occuring words. 
	 	Suppose you are given a book, get the top n occurring words from it.
	 */ 
	 	public class wordInfo{
	 		int frequency; 
	 		boolean rank; 
	 	}

	 	ArrayList<String> topNWords = new ArrayList<String>();

	 	public ArrayList<String> getWords(List<String> words, int N){
	 		for(String word: words){
	 			getTopNWords(word, N); 
	 		}
	 		return topNWords; 
	 	}
	 	
	 	public void getTopNWords(String word, int N)
	 	{
	 		HashMap<String, wordInfo> wordInfo = new HashMap<String, wordInfo>(); 
	 		Comparator<String> frequencyComparator = (s1, s2) -> Integer.valueOf(wordInfo.get(s2).frequency)
	 		.compareTo(wordInfo.get(s1).frequency); 

	 	
	 			wordInfo info = wordInfo.get(word); 
	 			if (info == null){
	 				info = new wordInfo(); 
	 				wordInfo.put(word, info);  
	 			} 
	 			else {
	 				info.frequency++;  
	 			}
			// add first word
	 			if(topNWords.isEmpty()){
	 				topNWords.add(word); 
	 				info.rank = true; 
	 			}

				if(info.rank){ // sort words in order of frequency 
					for(String w : topNWords){
						Collections.sort(topNWords, frequencyComparator); 
					}
				}

				// topNWords list is sorted at this point; check the last added word with the current word
				String lastWord = topNWords.get(topNWords.size() - 1); 
				if(wordInfo.get(lastWord).frequency < info.frequency){
					topNWords.add(word); 
					wordInfo.get(word).rank = true; 
					Collections.sort(topNWords, frequencyComparator); 
					if(topNWords.size() > N){
						String toRemove = topNWords.get(topNWords.size() - 1); 
						topNWords.remove(toRemove); 
						wordInfo.get(toRemove).rank = false; 
					}
				}
				else if(wordInfo.get(lastWord).frequency > info.frequency){
					topNWords.add(word); 
					info.rank = true; 
				}
		}		

	public static void main(String[] args){
		ArrayList<String> list =  new ArrayList<String>(); 
		list.add("play"); 
		list.add("blue"); 
		list.add("blue"); 
		list.add("blue"); 

		list.add("stone"); 
		list.add("stone"); 
		list.add("pink"); 
		list.add("pink"); 

		list.add("green"); 

		list.add("green"); 
		list.add("green"); 
		list.add("green"); 
		list.add("green"); 
		day1 one = new day1(); 
		ArrayList<String> res = one.getWords(list, 3); 
		System.out.println(res); 
	}
}