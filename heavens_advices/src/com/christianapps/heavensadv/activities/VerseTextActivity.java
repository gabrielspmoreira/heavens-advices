package com.christianapps.heavensadv.activities;

import com.christianapps.heavensadv.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.christianapps.heavensadv.values.BibleVerse;

public class VerseTextActivity extends Activity {
    BibleVerse bibleVerse;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verse_text);
        
        Bundle extras = getIntent().getExtras(); 
	  	bibleVerse = (BibleVerse) extras.getSerializable("bibleverse");	 
	  	setTitle(getResources().getString(R.string.app_name) + " - " + bibleVerse.getVerseId());
	  	
	  	TextView bibleVerseText = (TextView) findViewById(R.id.bibleversetext);
	  	bibleVerseText.setText(bibleVerse.getVerseText());
    }
    
  
}