package com.example.easy_slim_beta;


import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class CaloriasActivity extends Activity{
	
	protected AdView adView;	
	public final static String EXTRA_MESSAGE = "com.example.easy_slim_beta.NUTRIENTTYPEMESSAGE";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calorias);
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());		      
	     
	 }
	
	public void vitaminsClick(View view) {
		Intent mineralsIntent = new Intent(this, NutrientsListActivity.class);
		mineralsIntent.putExtra(EXTRA_MESSAGE, "vitamin");
		startActivity(mineralsIntent);
	}
	
	public void mineralsClick(View view) {
		Intent vitaminsIntent = new Intent(this, NutrientsListActivity.class);
		vitaminsIntent.putExtra(EXTRA_MESSAGE, "mineral");
		startActivity(vitaminsIntent);
	}

}