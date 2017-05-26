package markovChain;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovChain {
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
				w = map.get(words.get(s));								//duplicates current list of words and adds to it
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

	public static String predict(String str1){
		String delimiters = "[\\W]+";
		String[] st = str1.split(delimiters);
		int max = 0;
		String prob = "";
		if(map.containsKey(st[st.length-1])){
			ArrayList<String> temps = map.get(st[st.length-1]);
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			for(String temp : temps){
				if(m.containsKey(temp)){
					m.put(temp, m.get(temp)+1);
				} else {
					m.put(temp, 1);
				}
			}
			for(int j = 0; j < temps.size(); j++){
				if(max < m.get(temps.get(j))){
					max = m.get(temps.get(j));
					prob = temps.get(j);
				}
			}
			return prob;
		} else {
			return "Error 404, String Not Found";
		}
	}
}
 
