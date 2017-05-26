package markovChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovChain {
	//public MarkovChain(){ }
	public static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	static String strr = "That thou hast her it "
			+ "is not all my grief, And yet it may be said I "
			+ "loved her dearly, That she hath thee"
			+ " is of my wailing chief, A loss"
			+ " in love that touches me more nearly. "
			+ "Loving offenders thus I will excuse ye,"
			+ " Thou dost love her, because thou know'st I "
			+ "love her, And for my sake even so doth she abuse me,"
			+ " Suff'ring my friend for my sake to approve her."
			+ " If I lose thee, my loss is my love's gain, And"
			+ " losing her, my friend hath found that loss, Both"
			+ " find each other, and I lose both twain,And both"
			+ " for my sake lay on me this cross, But here's the"
			+ " joy, my friend and I are one, Sweet flattery,"
			+ " then she loves but me alone. Was it the proud full "
			+ "sail of his great verse, Bound for the "
			+ "prize of (all too precious) you, That "
			+ "did my ripe thoughts in my brain inhearse, "
			+ "Making their tomb the womb wherein they "
			+ "grew? Was it his spirit, by spirits taught "
			+ "to write, Above a mortal pitch, that struck"
			+ " me dead? No, neither he, nor his compeers"
			+ " by night Giving him aid, my verse "
			+ "astonished. He nor that affable familiar"
			+ " ghost Which nightly gulls him with "
			+ "intelligence, As victors of my silence "
			+ "cannot boast, I was not sick of any fear"
			+ " from thence. But when your countenance "
			+ "filled up his line, Then lacked I matter, "
			+ "that enfeebled mine. Whilst I alone did call upon thy aid, "
			+ "My verse alone had all thy gentle grace,But now my gracious"
			+ " numbers are decayed, And my sick muse doth give an other place."
			+ "I grant (sweet love) thy lovely argument Deserves the travail of a "
			+ "worthier pen, Yet what of thee thy poet doth invent, He robs thee of, "
			+ "and pays it thee again, He lends thee virtue, and he stole that word, "
			+ "From thy behaviour, beauty doth he give And found it in thy "
			+ "cheek: he can afford No praise to thee, but what in thee doth "
			+ "live. Then thank him not for that which he say, Since what he owes "
			+ "thee, thou thy self dost pay. Poor soul the centre of my sinful earth, My sinful earth these rebel powers array,Why dost thou pine within and suffer dearth Painting thy outward walls so costly gay? Why so large cost "
			+ "having so short a lease, Dost thou upon thy fading mansion spend?"
			+ " Shall worms inheritors of this excess Eat up thy charge? is this"
			+ " thy body's end? Then soul live thou upon thy servant's loss, And "
			+ "let that pine to aggravate thy store; Buy terms divine in selling"
			+ " hours of dross; within be fed, without be rich no more, So "
			+ "shall thou feed on death, that feeds on men, And death once "
			+ "dead, there's no more dying then. Love is too young to know what conscience is, Yet who knows not "
			+ "conscience is born of love? Then gentle "
			+ "cheater urge not my amiss, Lest guilty of my faults thy "
			+ "sweet self prove. For thou betraying me, I do betray My nobler "
			+ "part to my gross body's treason, My soul doth tell my body that"
			+ " he may, Triumph in love, flesh stays no farther reason, But rising "
			+ "at thy name doth point out thee, As his triumphant prize, proud of this "
			+ "pride, He is contented thy poor drudge to be, To stand in thy affairs, fall "
			+ "by thy side. No want of conscience hold it that I call, Her love, for whose"
			+ " dear love I rise and fall.";
	
	static String song = "I am hot "
			+ "You are blank "
			+ "You blank around "
			+ "Like you blank "
			+ "Who I blank "
			+ "But you don't "
			+ "You have got me on "
			+ "My blank " 

			+ "I am blank into the blank "
			+ "And I am trying to keep from blank "
			+ "Baby you blank the blank hotter "
			+ "Cause I'm burnin' up, burnin' up "
			+ "For you baby "

			+ "Come on girl "

			+ "I blank " 
			+ "So blank "
			+ "Cannot hold myself back " 
			+ "High blank "
			+ "Red blank "
			+ "All by yourself "
			+ "blank catch my breath "

			+ "I am blank into the blank "
			+ "And I am trying to keep from blank "
			+ "Baby you blank the blank hotter "
			+ "Cause Im burnin' up, burnin' up "
			+ "For you baby "

			+ "Walk in the blank "
			+ "All I can blank is you "

			+ "Oh "

			+ "blank me down "
			+ "I know you blank it too "

			+ "I am blank into the blank "
			+ "And Im trying to keep from blank "
			+ "Baby you blank the blank hotter "
			+ "Cause Im burnin' up, burnin' up "
			+ "For you baby  "

			+ "I am blank into the blank "
			+ "And Im trying to keep from blank "
			+ "Baby you blank the blank hotter "
			+ "Cause Im burnin' up, burnin' up "
			+ "For you baby "

			+ "Burnin' up in the place tonight "
			+ "And the blank singing blank " 
			+ "Get blank and blank " 
			+ "Big blank for blank "
			+ "Stop, drop and roll " 
			+ "More and more "
			+ "I got blank with blank " 
			+ "Come on boys blank the blank around "

			+ "I am blank into the blank "
			+ "And Im trying to keep from blank "
			+ "Baby you blank the blank hotter "
			+ "Cause Im burnin' up, burnin' up "
			+ "For you baby "; 

	static String str = strr.replaceAll("’", "");
	static int wordcount = 0;
	public int[] probability = new int[wordcount];

	public static void main(String[] args) {
		ArrayList<String> text = createList(str);

		HashMap<String, ArrayList<String>> textMap = createMap(text);
		//System.out.println(textMap);
		//compare(strr, "thou");
		System.out.println(remake(song, strr)); 


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
				w = map.get(words.get(s));							//duplicates current list of words and adds to it
				//System.out.println(words.get(s)); 
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

	public static String compare(String words, String str)
	{
		ArrayList<String> text = createList(words);
		createMap(text);
		Random r = new Random(); 
		String returnstring = "";
		for(String s: map.keySet())
		{
			if(s.equals(str))
			{
				ArrayList<String> w = map.get(s);
				returnstring = w.get(r.nextInt(w.size()));
			}
		}
		System.out.println(returnstring);
		return returnstring; 
	}
	public static String remake(String song, String sonnets)
	{
		String returnstring = "";
		ArrayList<String> lyrics = createList(song);
		for(int i = 0; i< lyrics.size(); i++)
		{
			
			if(lyrics.get(i).equals("blank") || lyrics.get(i).equals("blank "))
			{
				returnstring = returnstring + " " + compare(sonnets, lyrics.get(i-1));
				
			}
			if(!lyrics.get(i).equals("blank"))
			{
				returnstring = returnstring + " " + lyrics.get(i);
			}
			
		}
		return returnstring; 
	}

	/*public static String predict(String str1){
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
	}*/

}

