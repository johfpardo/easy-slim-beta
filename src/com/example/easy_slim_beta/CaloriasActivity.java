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
	private ListView lv1;
	private String lv_arr[]={"  Vitaminas  ","  Minerales  "};


@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.calorias);
	adView = (AdView)findViewById(R.id.ad);
	adView.loadAd(new AdRequest());
	
	 lv1=(ListView)findViewById(R.id.listview);

     // By using setAdpater method in listview we an add string array in list.

     lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));


     lv1.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
       int position, long id) {
 	  
 	  switch (position) {
       case 0:
        Intent newActivity0 = new Intent(CaloriasActivity.this,VitaminasListActivity.class);     
        startActivity(newActivity0);
       break;
       case 1:
        Intent newActivity1 = new Intent(CaloriasActivity.this,MineralesListActivity.class);     
        startActivity(newActivity1);
       break;
       default:
	     
	    }
   }
 });

 }
	
}
