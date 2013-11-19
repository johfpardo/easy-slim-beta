package com.eltx.easy_slim_beta;


import java.util.ArrayList;
import java.util.List;

import com.eltx.easy_slim_beta.R;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

import easy_slim_beta.dao.NutrientDao;
import easy_slim_beta.entities.Nutrient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class CaloriasActivity extends Activity{
	private String type;
	private List<Nutrient> nutrients;	
	private ListView lv1;
	ArrayList<String> elements = new ArrayList();
	public final static String EXTRA_MESSAGE = "com.example.easy_slim_beta.MESSAGE";
	protected AdView adView;		

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calorias);
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());		      
	     
	 }
	
	public void vitaminsClick(View view) {		
		type= "vitamin";
		setList();				
	}
	
	public void mineralsClick(View view) {
		type = "mineral";
		setList();
	}
	
	public void setList(){				
		
		TextView typeView = (TextView) findViewById(R.id.typeView);		
		if(type.equals("vitamin")){
			typeView.setText(type + "as");
		}
		else{
			typeView.setText(type + "es");
		}
		nutrients = new NutrientDao(this).getNutrients(type);
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());
		elements.clear();
		 lv1=(ListView)findViewById(R.id.listview);

		//añadir los elementos de la base de datos a la lista
			 for (Nutrient nutrient : nutrients){
				  elements.add(nutrient.getName());
			 }
		 
	     // By using setAdpater method in listview we an add string array in list.

	     lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , elements));


	     lv1.setOnItemClickListener(new OnItemClickListener() {
	   public void onItemClick(AdapterView<?> parent, View view,
	       int position, long id) {
		   //get selected element name
		   String nutrientSelected = elements.get(position);
		   //start detailed view activity for the selected nutrient
	        Intent detailActivity = new Intent(CaloriasActivity.this,NutrientDetail.class);    
	        detailActivity.putExtra(EXTRA_MESSAGE, nutrientSelected);
	        startActivity(detailActivity);
	      
	   }
	     });
	}

}