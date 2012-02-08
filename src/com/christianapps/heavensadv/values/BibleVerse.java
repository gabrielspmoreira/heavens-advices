package com.christianapps.heavensadv.values;

import java.io.Serializable;

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
	
	public String toString(){
		return verseId;		
	}
}
