package com.christianapps.heavensadv.values;

import java.io.Serializable;
import java.util.StringTokenizer;

public class BibleVerse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4872405110236277755L;
	private String verseId;
	private String verseText;
	
	public BibleVerse(String verseId, String verseText){
		this.verseId = verseId;
		this.verseText = verseText;
	}
	
	public void setVerseId(String verseId) {
		this.verseId = verseId;
	}
	public String getVerseId() {
		return verseId;
	}
	public void setVerseText(String verseText) {
		this.verseText = verseText;
	}
	public String getVerseText() {
		return verseText;
	}
	
	public static BibleVerse parse(String text){
    	StringTokenizer tokenizer = new StringTokenizer(text, "|");  
    	String verse_id = tokenizer.nextToken();
    	String verse_text = tokenizer.nextToken();
    	
		return new BibleVerse(verse_id, verse_text);
    }
	
	@Override 
	public String toString(){
		return verseId;		
	}
	
	@Override 
	public boolean equals(Object object){
		if (this == object) return true;
		
		if ( !(object instanceof BibleVerse) ) return false;
		
		BibleVerse verse = (BibleVerse) object;
		
		return verseId.equals(verse.verseId) && verseText.equals(verse.verseText);
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (verseText == null ? 10 : verseText.length());
		return result;
	}
}
