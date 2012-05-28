package com.christianapps.heavensadv.adapters;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.christianapps.heavensadv.R;

public class MainMenuImagesAdapter extends BaseAdapter {
    private Context mContext;
    
    private HashMap<Integer, String> menuItems;
    
    public MainMenuImagesAdapter(Context c) {
        mContext = c;
        menuItems = new HashMap<Integer, String>();
    	menuItems.put(R.drawable.heavens1, mContext.getString(R.string.mainmenu_situations));
    	menuItems.put(R.drawable.heavens2, mContext.getString(R.string.mainmenu_random));
    }

    public int getCount() {
        return menuItems.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {    	
    	LinearLayout imageMenu;
    	if (convertView == null) {  // if it's not recycled, initialize some attributes
	    	imageMenu = (LinearLayout) ((Activity) mContext).getLayoutInflater().inflate(R.layout.menu_image_row,null);
    	}else {
    		imageMenu = (LinearLayout) convertView;
        }
    	
    	int key = (Integer) menuItems.keySet().toArray()[position];
    	imageMenu.setBackgroundResource(key);

    	TextView textMenu = (TextView) imageMenu.findViewById(R.id.imageViewText);
    	textMenu.setText(menuItems.get(key));
    	
    	return imageMenu;
    }

    

}