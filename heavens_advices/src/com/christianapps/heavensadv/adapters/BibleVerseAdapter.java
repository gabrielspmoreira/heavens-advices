package com.christianapps.heavensadv.adapters;

import java.util.List;

import com.christianapps.heavensadv.R;
import com.christianapps.heavensadv.values.BibleVerse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BibleVerseAdapter extends BaseAdapter {
	private Context contextItem;
	private List<BibleVerse> bibleVerses;
	
	 public BibleVerseAdapter(Context context, List<BibleVerse> list) {
		contextItem = context;
		bibleVerses = list;
	 }

	public int getCount() {
		return bibleVerses.size();
	}

	public Object getItem(int pos) {
		return bibleVerses.get(pos);
	}

	public long getItemId(int pos) {
		return pos;
	}

	public View getView(int pos, View convertView, ViewGroup parent) {
    	BibleVerse bibleVerse = bibleVerses.get(pos);
    	
    	// inflating list view layout if null
    	if(convertView == null) {
    		LayoutInflater inflater = LayoutInflater.from(contextItem);
    	    convertView = inflater.inflate(R.layout.bible_verses_row, null);
    	}
    	
    	TextView verseIdTextView = (TextView)convertView.findViewById(R.id.verseid);
    	verseIdTextView.setText(bibleVerse.getVerseId());

    	TextView verseTextView = (TextView)convertView.findViewById(R.id.versetext);
    	String fullBibleVerse = bibleVerse.getVerseText();
    	String shortBibleVerse = bibleVerse.getVerseText().substring(1, Math.min(80, fullBibleVerse.length())) + "...";
    	verseTextView.setText(shortBibleVerse);

    	return convertView;
    }


}
