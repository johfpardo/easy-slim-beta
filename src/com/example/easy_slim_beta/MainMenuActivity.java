package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import easy_slim_beta.entities.UserProfile;


public class MainMenuActivity extends Activity implements OnClickListener{
	
	SharedPreferences sharedPref;
	protected AdView adView;
	static UserProfile user = new UserProfile();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());
		
		Button boton = (Button)findViewById(R.id.buttonRecomend);
		boton.setOnClickListener(this);  	
		    
		Button boton2 = (Button)findViewById(R.id.buttonIMC);
		boton2.setOnClickListener(this);  
		    
		Button boton3 = (Button)findViewById(R.id.buttonModif);
		boton3.setOnClickListener(this); 
		
		Button boton4 = (Button)findViewById(R.id.buttonPorcion);
		boton4.setOnClickListener(this);
		
		Button boton5 = (Button)findViewById(R.id.buttonCalorias);
		boton5.setOnClickListener(this);
		
		load();
	}
		
	@Override
    public void onClick(View v) {
        
        switch(v.getId()){
            case R.id.buttonRecomend:
            	startActivity(new Intent(this, AdviceActivity.class));
            	break;
            case R.id.buttonIMC:
            	startActivity(new Intent(this, InfoActivity.class));
            	break;	
            case R.id.buttonModif:
            	startActivity(new Intent(this, FormActivity.class));
            	break;	
            case R.id.buttonPorcion:
            	startActivity(new Intent(this, PorsionesActivity.class));
            	break;	
            case R.id.buttonCalorias:
            	startActivity(new Intent(this, CaloriasActivity.class));
            	break;
        }        	       
        }
	
	
	public void load (){
		sharedPref = getSharedPreferences(getString(R.string.user_profile),0);
		String name = sharedPref.getString(getString(R.string.name), "");
		int year = sharedPref.getInt(getString(R.string.year), 0);
		int month = sharedPref.getInt(getString(R.string.month), 0);
		int day = sharedPref.getInt(getString(R.string.day), 0);
		float height = sharedPref.getFloat(getString(R.string.height), 0);
		float weight = sharedPref.getFloat(getString(R.string.weight), 0);
		boolean sex = sharedPref.getBoolean(getString(R.string.sex), false);
		
		user.set(name, year, month, day, height, weight, sex);	
		
		TextView nameview = (TextView) findViewById(R.id.welcomeView);
		nameview.append("  ");
		nameview.append(user.getName());
		
	}
}
	