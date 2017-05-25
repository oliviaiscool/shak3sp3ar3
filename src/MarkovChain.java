package markovChain;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovChain {
	//public MarkovChain(){ }
	public static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private static String strr = "What the fuck did you just fucking say about me, you little bitch? I’ll have you know I graduated top of my class in the Navy Seals, and I’ve been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I’m the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You’re fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little “clever” comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn’t, you didn’t, and now you’re paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You’re fucking dead, kiddo.";
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
				//w = map.get(s);								//duplicates current list of words and adds to it
				w.add(words.get(s+1));
				
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
 
