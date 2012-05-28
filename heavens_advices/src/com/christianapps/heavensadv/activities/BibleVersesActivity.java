package com.christianapps.heavensadv.activities;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.christianapps.heavensadv.*;

import com.christianapps.heavensadv.actionbar.ActionBarButton;
import com.christianapps.heavensadv.adapters.BibleVerseAdapter;
import com.christianapps.heavensadv.values.BibleVerse;
import com.christianapps.heavensadv.values.Situation;

public class BibleVersesActivity extends HeavensActivity {
	
	private ArrayList<BibleVerse> bibleVerses = new ArrayList<BibleVerse>(); 
	
	@Override
	protected ActionBarButton[] getActionButtons(){
		return new ActionBarButton[]{ActionBarButton.About};
	}
	
	@Override
	protected void OnActionBarButtonClicked(ActionBarButton actionBarButton) {
		// TODO Auto-generated method stub
		
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bible_verses);
        
	  	Bundle extras = getIntent().getExtras(); 
	  	Situation situation = (Situation) extras.getSerializable("situation");	 
	  	setTitle(getResources().getString(R.string.app_name) + " - " + situation.getName());
	  	
	  	bibleVerses = situation.getBibleVerses();
	  	//ArrayAdapter<BibleVerse> arrayAdapter = new ArrayAdapter<BibleVerse>(this, android.R.layout.simple_list_item_1, bibleVerses);
	  	
	  	BibleVerseAdapter bibleVerseAdapter = new BibleVerseAdapter(this, bibleVerses);
	  	
	  	ListView lv = (ListView) findViewById(R.id.verses_list);
	  	lv.setAdapter(bibleVerseAdapter);
	  	lv.setTextFilterEnabled(true);
	  	  
	  	  lv.setOnItemClickListener(new OnItemClickListener() {
	  	    public void onItemClick(AdapterView<?> parent, View view,
	  	         int position, long id) {
	  	    	
	  	    	 //BibleVerse bibleVerse = bibleVerses.get((int)id);
	  	    	
	  	    	 Intent intent = new Intent(view.getContext(), VerseTextActivity.class);		  	   
	  	    	intent.putExtra("bibleverses", bibleVerses);
	  	    	intent.putExtra("bibleverse_position", position);
				
				 startActivity(intent);	  	    
	  	    }
	  	  });
    }
    
     
}