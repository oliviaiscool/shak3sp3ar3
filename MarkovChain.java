package MarkovChain;

import java.util.ArrayList;

public class MarkovChain {
	//public MarkovChain(){ }

	HashMap<Word, <List<Word>> map = new HashMap<Word, <List<Word>>;
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
	public void createMap(){

		for(int i = 0; i < string.size(); i++){
			map.put(string.get(i), new List("", "")); //not entirely sure what goes here 
			map.get(i).add("");
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
			
			for(int ind : index){ 			//look at the two words after that word in each case. 
				
				if(ind < words.size()-1){
					str.add(words.get(ind+1));
					str.add(words.get(ind+2));
				} else if(ind < words.size()){
				
					str.add(words.get(ind+1));
				
				}
			
			}
			
			for(int i = 0; i < str.size()-1; i++){          //If any of those two words show up more than once, make that probability greater
			
				for(int j = i+1; j < str.size(); j++){
			
					if((str.get(i)).equals(str.get(j))){
						//make probability greater
					}
			
				}
			
			}	
		}
	}
}