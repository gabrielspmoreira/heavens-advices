package com.christianapps.heavensadv.activities;

import java.util.Random;

import com.christianapps.heavensadv.R;
import com.christianapps.heavensadv.actionbar.ActionBarButton;
import com.christianapps.heavensadv.adapters.MainMenuImagesAdapter;
import com.christianapps.heavensadv.values.BibleVerse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


public class MainMenuActivity extends HeavensActivity {	
	
	@Override
	protected ActionBarButton[] getActionButtons(){
		return new ActionBarButton[]{ActionBarButton.About};
	}
	
	@Override
	protected void OnActionBarButtonClicked(ActionBarButton actionBarButton){
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		GridView gridview = (GridView) findViewById(R.id.mainmenu);
	    gridview.setAdapter(new MainMenuImagesAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	    	public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				if (position==0){
					Intent intent = new Intent(view.getContext(), SituationsActivity.class);
					startActivity(intent);
				}
				else if (position == 1){
					 Intent intent = new Intent(view.getContext(), VerseTextActivity.class);		  	   
					 intent.putExtra("bibleverse", getRandomVerseBible());					
					 startActivity(intent);	 
				}
			}
	    });
		
	}
	
	
	private BibleVerse getRandomVerseBible()
	{
		String[] promissesArray = getResources().getStringArray(com.christianapps.heavensadv.R.array.promissesarray);

		Random random = new Random();
		return BibleVerse.parse(promissesArray[random.nextInt(promissesArray.length - 1)]);

	}

}
