package markovChain;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovChain {
	//public MarkovChain(){ }
	public static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static String strr = "Hi there my name is aidan and my name";
	static String str = strr.replaceAll("’", "");
	static int wordcount = 0;
	public int[] probability = new int[wordcount];
	
	public static void main(String[] args) {
		ArrayList<String> text = createList(str);

		HashMap<String, ArrayList<String>> textMap = createMap(text);
		System.out.println(textMap);
		
	}

	public static ArrayList<String> createList(String str) {
		ArrayList<String> words = new ArrayList<String>(); 
		String delimiters = "[\\W]+";
		String[] list = str.split(delimiters);
		
		for (String s: list) {

			String wrd = s;
			
			words.add(wrd);
			wordcount++;
		}

		System.out.println(words.size());
		return words; 
	}

	public static HashMap<String, ArrayList<String>> createMap(ArrayList<String> words)
	{
		//checks all but last word
		for(int s = 0; s < words.size()-1; s++){
			if(map.containsKey( words.get(s) )) 
			{
				ArrayList<String> w = new ArrayList<String>();	
				w = map.get(s);								//duplicates current list of words and adds to it
				w.add(words.get(s+1));						//there is something wrong with this line and we have no idead what it is 
				map.put(words.get(s), w);					//overwrites old value, adds new list
			} else {
				ArrayList<String> stuff = new ArrayList<String>();
				stuff.add(words.get(s+1));
				map.put(words.get(s), stuff); 			//adds new key and list
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
 
