package com.Embedded.Solutions.DrivingLog;



import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        Config.setLanguage();
		this.setTitle(Lang.getTitle());
		
		
		// TODO: Remove
//		Test.fillDB(this);
//		File_IO.writeErrorMessage(this, "Dette er en est errorMsg");

        
		Resources res = getResources(); // Resource object to get Drawables
		final TabHost tabHost = getTabHost(); // The activity TabHost
         
		Intent intent = new Intent(this, NewItemActivity.class);
		tabHost.addTab(tabHost.newTabSpec(Lang.get(Lang.NEW))
				.setIndicator(Lang.get(Lang.NEW), res.getDrawable(R.drawable.ic_menu_add))
				.setContent(intent));

		
		intent = new Intent(this, ItemListActivity.class);
		tabHost.addTab(tabHost.newTabSpec(Lang.get(Lang.LIST))
				.setIndicator(Lang.get(Lang.LIST), res.getDrawable(R.drawable.ic_menu_sort_by_size))
				.setContent(intent));

		intent = new Intent(this, SendItemsActivity.class);
		tabHost.addTab(tabHost
				.newTabSpec(Lang.get(Lang.SEND))
				.setIndicator(Lang.get(Lang.SEND), res.getDrawable(R.drawable.ic_menu_send))
				.setContent(intent));

		intent = new Intent(this, HelpActivity.class);
		tabHost.addTab(tabHost
				.newTabSpec(Lang.get(Lang.HELP))
				.setIndicator(Lang.get(Lang.HELP), res.getDrawable(R.drawable.ic_menu_help))
				.setContent(intent));
		

		
		tabHost.setCurrentTab(0);

		
		// Set tabs Colors
		tabHost.setBackgroundColor(Color.BLACK);
		tabHost.getTabWidget().setBackgroundColor(Color.BLACK);
		
		
	    ItemListSingleton ils = ItemListSingleton.getInstance();
   
	    tabHost.setOnTabChangedListener(new OnTabChangeListener()
        {
        public void onTabChanged(String tabId)
            {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(tabHost.getApplicationWindowToken(), 0);
            }
        });
	    
	}
}
