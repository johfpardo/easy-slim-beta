package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainMenuActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
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
            	startActivity(new Intent(this, RecomendacionActivity.class));
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
}
	