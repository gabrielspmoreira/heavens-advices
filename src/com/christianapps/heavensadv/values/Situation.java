package com.christianapps.heavensadv.values;

import java.io.Serializable;
import java.util.ArrayList;


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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
