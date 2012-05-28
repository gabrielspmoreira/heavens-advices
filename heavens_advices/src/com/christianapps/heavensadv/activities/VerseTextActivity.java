package com.christianapps.heavensadv.activities;

import java.util.ArrayList;

import com.christianapps.heavensadv.R;

import android.os.Bundle;
import android.widget.TextView;

import com.christianapps.heavensadv.actionbar.ActionBarButton;
import com.christianapps.heavensadv.values.BibleVerse;

public class VerseTextActivity extends HeavensActivity {
    private BibleVerse bibleVerse;
    private int bibleVersePosition;
    private ArrayList<BibleVerse> relatedBibleVerses;
    
    @Override
	protected ActionBarButton[] getActionButtons(){
		return new ActionBarButton[]{ActionBarButton.PriorVerse, ActionBarButton.NextVerse, ActionBarButton.Share};
	}
	
	@Override
	protected void OnActionBarButtonClicked(ActionBarButton actionBarButton) {
		switch (actionBarButton) {
		case NextVerse:
			moveBibleVerse(1);
			break;
		
		case PriorVerse:
			moveBibleVerse(-1);
			break;
			
		default:
			break;
		}
	}
	
	/** Called when the activity is first created. */
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verse_text);
        
        Bundle extras = getIntent().getExtras(); 
	  	bibleVerse = (BibleVerse) extras.getSerializable("bibleverse");	 	  	
	  	if (extras.containsKey("bibleverses")){
	  		bibleVersePosition = (int) extras.getInt("bibleverse_position");
	  		relatedBibleVerses = (ArrayList<BibleVerse>) extras.getSerializable("bibleverses");	
	  		bibleVerse = relatedBibleVerses.get(bibleVersePosition);
	  	}
	  		  	
	  	showBibleVerse();
    }
    
    private void moveBibleVerse(int move){
    	if (relatedBibleVerses == null){
    		return;
    	}
    	
    	bibleVersePosition += move;
    	if (bibleVersePosition < 0){
    		bibleVersePosition = relatedBibleVerses.size() - 1;
    	}
    	else if (bibleVersePosition >= relatedBibleVerses.size()){
    		bibleVersePosition = 0;
    	}
    	bibleVerse = relatedBibleVerses.get(bibleVersePosition);
    	
    	showBibleVerse();
    }
    
    private void showBibleVerse(){
    	getSupportActionBar().setSubtitle(bibleVerse.getVerseId());	  	
	  	TextView bibleVerseText = (TextView) findViewById(R.id.bibleversetext);
	  	bibleVerseText.setText(bibleVerse.getVerseText());
    }
}