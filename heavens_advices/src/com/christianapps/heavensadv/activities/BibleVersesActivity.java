package com.christianapps.heavensadv.activities;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import com.christianapps.heavensadv.*;

import com.christianapps.heavensadv.values.BibleVerse;
import com.christianapps.heavensadv.values.Situation;

public class BibleVersesActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	  	Bundle extras = getIntent().getExtras(); 
	  	Situation situation = (Situation) extras.getSerializable("situation");	 
	  	setTitle(getResources().getString(R.string.app_name) + " - " + situation.getName());
	  	
	  	bibleVerses = situation.getBibleVerses();
	  	ArrayAdapter<BibleVerse> arrayAdapter = new ArrayAdapter<BibleVerse>(this, android.R.layout.simple_list_item_1, bibleVerses);
		setListAdapter(arrayAdapter);
	  	ListView lv = getListView();
	  	lv.setTextFilterEnabled(true);
	  	  
	  	  lv.setOnItemClickListener(new OnItemClickListener() {
	  	    public void onItemClick(AdapterView<?> parent, View view,
	  	        int position, long id) {
	  	    	
	  	    	BibleVerse bibleVerse = bibleVerses.get((int)id);
	  	    	
	  	    	AlertDialog alertDialog = new AlertDialog.Builder(BibleVersesActivity.this).create();
	  	    	alertDialog.setTitle(bibleVerse.getVerseId());
	  	    	//alertDialog.setMessage(bibleVerse.getVerseText());
	  	    	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int which) {
	                	return;
	                    }
	            });	  	    
	  	    	alertDialog.setView(GetDialogScreen(bibleVerse.getVerseText())); 
	  	    	alertDialog.show();
	  	    }
	  	  });
    }
    
    private View GetDialogScreen(String strText) {
        ScrollView scroll = new ScrollView(BibleVersesActivity.this);
        scroll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        LinearLayout llay = new LinearLayout(BibleVersesActivity.this);
        llay.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        llay.setBackgroundColor(Color.TRANSPARENT);
        TextView tv = new TextView(BibleVersesActivity.this);
        tv.setText(strText);
        tv.setTextSize(20);
        scroll.addView(llay);
        llay.addView(tv);
        return scroll;
    }
    
    private ArrayList<BibleVerse> bibleVerses = new ArrayList<BibleVerse>();  
}