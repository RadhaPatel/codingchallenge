import java.io.*;
import java.util.*;

public class Day1
{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] words = in.nextLine().split(" ");
		for(String word : topWords(words, 3)) {
			System.out.print(word + " ");
		}
	}

	public static String[] topWords(String[] words, int n) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) {
			if(map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count + 1);
			}
			else {
				map.put(word, 1);
			}
		}
		List<Word> sortWords = new ArrayList<Word>();
		for(String word : map.keySet()) {
			Word w = new Word(word, map.get(word));
			sortWords.add(w);
		}
		Collections.sort(sortWords);
		String[] top = new String[n];
		for(int i = 0; i < n; i++) {
			top[i] = sortWords.get(i).str;
		}
		return top;
	}

	static class Word implements Comparable
	{
		public String str;
		public int count;

		public Word(String s, int c) {
			str = s;
			count = c;
		}

		public int compareTo(Object obj) {
			Word other = (Word) obj;
			return other.count - count;
		}
	}
}