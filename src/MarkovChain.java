package MarkovChain;

import java.util.ArrayList;

public class MarkovChain {
	//public MarkovChain(){ }

	HashMap<Word, List<Word>> map = new HashMap<Word, List<Word>>;
	static ArrayList<String> words = new ArrayList<String>(); 
	private String string = "Hi there my name is aidan oakley and i really like to party and stuff.";
	static int wordcount = 0;
	public int[] probability = new int[wordcount];
	
	/*
	 * @aidan
	 *
	 */
	public ArrayList<String> createList(String str) {
		String delimiters = "[\\W]+";
		String[] list = str.split(delimiters);
		
		for (String s: list) {

			Word wrd = new Word(s);
			
			words.add(wrd);
			wordcount++;
		}

		System.out.println(wordcount);
		return words; 
	}

	/*
	 * @ciara
	 *
	 */
	public void createMap(ArrayList<String> words){

		for(int i = 0; i < words.size()-1; i++){			//checks all but last word
			if(map.containsKey(words.get(i))){	
				List<Word> w = new List<Word>;	
				w = map.get(i);								//duplicates current list of words and adds to it
				w.add(words.get(i+1));
				map.put(words.get(i), w);					//overwrites old value, adds new list
			} else {
				map.put(words.get(i), new List(words.get(i+1))); 			//adds new key and list
			}
		}
	}
	public int[] makeProbability(ArrayList<String> words){
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
	}
}