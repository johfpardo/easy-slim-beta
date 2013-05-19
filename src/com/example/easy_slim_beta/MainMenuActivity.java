package com.example.easy_slim_beta;

import easy_slim_beta.entities.UserProfile;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.ads.AdRequest;
import com.google.ads.AdView;


public class MainMenuActivity extends Activity implements OnClickListener{
	
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
	
	@SuppressLint("InlinedApi")
	public void load (){
		SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.user_profile),Context.MODE_MULTI_PROCESS);
		String name = sharedPref.getString(getString(R.string.name), null);
		int year = sharedPref.getInt(getString(R.string.year), (Integer) null);
		int month = sharedPref.getInt(getString(R.string.month), (Integer) null);
		int day = sharedPref.getInt(getString(R.string.day), (Integer) null);
		float height = sharedPref.getFloat(getString(R.string.height), (Float) null);
		float weight = sharedPref.getFloat(getString(R.string.weight), (Float) null);
		boolean sex = sharedPref.getBoolean(getString(R.string.sex), (Boolean) null);
		
		user.set(name, year, month, day, height, weight, sex);	
	}
}
	