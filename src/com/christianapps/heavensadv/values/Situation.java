package com.christianapps.heavensadv.values;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Situation implements Serializable 
{

	private static final long serialVersionUID = -1253516973684680694L;
	
	private String id;
	private String name;
	private ArrayList<BibleVerse>  bibleVerses;
	
	public Situation(String id, String name, ArrayList<BibleVerse>  bibleVerses){
		this.id = id;
		this.name = name;
		this.bibleVerses = bibleVerses;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBibleVerses(ArrayList<BibleVerse>  bibleVerses) {
		this.bibleVerses = bibleVerses;
	}

	public ArrayList<BibleVerse>  getBibleVerses() {
		return bibleVerses;
	}
			
	
	public String toString(){
		return name;
	}
	
	public static Situation parse(String text, String[] verses_array){    	
    	StringTokenizer tokenizer = new StringTokenizer(text, "|");  
    	String id = tokenizer.nextToken();
    	String name = tokenizer.nextToken();
    	    	   	
    	int array_lenght = verses_array.length;
    	ArrayList<BibleVerse> bibleVerses = new ArrayList<BibleVerse>();
    	for (int i=0; i< array_lenght; i++){
    		String fullText = verses_array[i];
    		BibleVerse verse = BibleVerse.parse(fullText);
    		bibleVerses.add(verse);
    	}
    	
    	return new Situation(id, name, bibleVerses);
    }
}
