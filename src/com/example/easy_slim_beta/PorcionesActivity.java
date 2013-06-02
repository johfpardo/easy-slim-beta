package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class PorcionesActivity extends Activity implements OnClickListener{
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.porciones);
				
		Button boton = (Button)findViewById(R.id.button1);
		Button boton1 = (Button)findViewById(R.id.button2);
		Button boton2 = (Button)findViewById(R.id.button3);
		Button boton3 = (Button)findViewById(R.id.button4);
		Button boton4 = (Button)findViewById(R.id.button5);
		Button boton5 = (Button)findViewById(R.id.button6);
		Button boton6 = (Button)findViewById(R.id.button7);
		Button boton7 = (Button)findViewById(R.id.button8);
		//Button boton8 = (Button)findViewById(R.id.button2);
		boton.setOnClickListener(this);
		boton1.setOnClickListener(this);
		boton2.setOnClickListener(this);
		boton3.setOnClickListener(this);
		boton4.setOnClickListener(this);
		boton5.setOnClickListener(this);
		boton6.setOnClickListener(this);
		boton7.setOnClickListener(this);
		//boton8.setOnClickListener(this);
		
	}
	

    public void onClick(View v) {
        
            	startActivity(new Intent(this, PortionsActivity.class));      	       
        }

}


