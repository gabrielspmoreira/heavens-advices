package com.christianapps.heavensadv.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.christianapps.heavensadv.R;
import com.christianapps.heavensadv.actionbar.ActionBarButton;

public abstract class HeavensActivity extends SherlockActivity {
	
	protected abstract ActionBarButton[] getActionButtons();
	
	protected abstract void OnActionBarButtonClicked(ActionBarButton actionBarButton);

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		ActionBarButton[] actionBarButtons = getActionButtons();
		
		for (ActionBarButton actionBarButton : actionBarButtons) {
			int actionBarButtonId = actionBarButton.ordinal();
			
			String title = null;
			int imageResourceId = 0;
						
			switch (actionBarButton) {
			case About:
				title = "About";
				imageResourceId = R.drawable.ab_action_help;
				break;
			
			case NextVerse:
				title = "Next Verse";
				imageResourceId = R.drawable.ab_navigation_next_item;
				break;
				
			case PriorVerse:
				title = "Prior Verse";
				imageResourceId = R.drawable.ab_navigation_previous_item;
				break;
				
			case Back:
				title = "Back";
				imageResourceId = R.drawable.ab_navigation_back;
				break;

			case Share:
				title = "Share";
				imageResourceId = R.drawable.ab_social_group;
				break;
				
			default:
				return false;
			}
			
			menu.add(title).setIcon(imageResourceId)
				.setNumericShortcut(String.valueOf(actionBarButtonId).charAt(0))
	            .setOnMenuItemClickListener(new com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener(){				 
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						int actionButtonId = Integer.parseInt(String.valueOf(item.getNumericShortcut()));
						ActionBarButton actionButton = ActionBarButton.values()[actionButtonId];
						ActionBarButtonClicked(actionButton);
						return true;
				}
            	
            })
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		}
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		setTheme(R.style.Theme_Sherlock_Light_DarkActionBar);
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(getString(R.string.app_name));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{    
	   switch (item.getItemId()) 
	   {        
	      case android.R.id.home:   
	         Intent intent = new Intent(this, MainMenuActivity.class);            
	         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	         startActivity(intent);            
	         return true;        
	      default:            
	         return super.onOptionsItemSelected(item);    
	   }
	}
	
	protected void ActionBarButtonClicked(ActionBarButton actionBarButton){
		if (actionBarButton == ActionBarButton.About){
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
	    	alertDialog.setTitle(getString(R.string.about));
	    	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					return;
				}
			});
	    	
	    	alertDialog.setView(getLayoutInflater().inflate(R.layout.dialog_about,null)); 
	    	alertDialog.show();
		}

		OnActionBarButtonClicked(actionBarButton);
	}
}
