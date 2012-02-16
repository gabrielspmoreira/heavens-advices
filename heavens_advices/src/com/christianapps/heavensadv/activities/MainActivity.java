package com.christianapps.heavensadv.activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.christianapps.heavensadv.values.BibleVerse;
import com.christianapps.heavensadv.values.Situation;
import com.christianapps.heavensadv.*;

public class MainActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		//String locale = getResources().getConfiguration().locale.getDisplayName();
		
		final String[] mainMenuOptions = new String[] {getResources().getString(R.string.mainmenu_random), 
												       getResources().getString(R.string.mainmenu_situations)};

		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainMenuOptions));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				if (mainMenuOptions[(int) id].equalsIgnoreCase(getResources().getString(R.string.mainmenu_random)))
				{
					showRandomBibleVerse();
				}
				else if (mainMenuOptions[(int) id].equalsIgnoreCase(getResources().getString(R.string.mainmenu_situations)))
				{
					Intent intent = new Intent(view.getContext(), SituationsActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	/*
	 * Shows an Alert with a random Bible verse.
	 */
	private void showRandomBibleVerse()
	{
		BibleVerse bibleVerse = getRandomVerseBible();
		AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
		alertDialog.setTitle(bibleVerse.getVerseId());
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});

		alertDialog.setView(ViewDialogScreen(bibleVerse.getVerseText())); 
		alertDialog.show();
	}

	private View ViewDialogScreen(String strText) {
		ScrollView scroll = new ScrollView(MainActivity.this);
		scroll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		LinearLayout llay = new LinearLayout(MainActivity.this);
		llay.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		TextView tv = new TextView(MainActivity.this);
		tv.setText(strText);
		tv.setTextSize(20);
		scroll.addView(llay);
		llay.addView(tv);
		return scroll;
	}


	private BibleVerse getRandomVerseBible()
	{
		String[] promissesArray = getResources().getStringArray(com.christianapps.heavensadv.R.array.promissesarray);

		Random random = new Random();
		return BibleVerse.parse(promissesArray[random.nextInt(promissesArray.length - 1)]);

	}
}