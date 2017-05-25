package markovChain;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovChain {
	//public MarkovChain(){ }

	public static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static ArrayList<String> words = new ArrayList<String>(); 
	private static String str = "Hi there my name is aidan oakley and aidan oakley really likes to party and stuff.";
	static int wordcount = 0;
	public int[] probability = new int[wordcount];
	
	public static void main(String[] args) {
		ArrayList text = createList(str);

		createMap(text);
	}

	public static ArrayList<String> createList(String str) {
		String delimiters = "[\\W]+";
		String[] list = str.split(delimiters);
		
		for (String s: list) {

			String wrd = s;
			
			words.add(wrd);
			wordcount++;
		}

		System.out.println(wordcount);
		return words; 
	}

	public static HashMap createMap(ArrayList<String> words)
	{
		//checks all but last word
		for(int i = 0; i < words.size()-1; i++){
			if(map.containsKey( words.get(i) ))
			{
				ArrayList<String> w = new ArrayList<String>();	
				w = map.get(i);								//duplicates current list of words and adds to it
				w.add(words.get(i+1));
				map.put(words.get(i), w);					//overwrites old value, adds new list
			} else {
				ArrayList<String> stuff = new ArrayList<String>();
				stuff.add(words.get(i+1));
				map.put(words.get(i), stuff); 			//adds new key and list
			}
		}
		return map;
	}


	/*public int[] makeProbability(ArrayList<String> words){
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<String> str = new ArrayList<String>();

		for(String s: words){

			String temp = s; 
			
			for(int i = 0; i < words.size(); i++){    //go through the list. yeah find all instances of the word. 
				if(s.equals(words.get(i))){
					index.add(i);
				}
			}
			
			createMap(words);								//adds words to map, including probablitity

		}
	}*/
}
 
