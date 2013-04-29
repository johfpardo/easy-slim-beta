package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class AppMenuActivity extends Activity {
 
	Button button2;
	Button button3;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		addListenerOnButton();
	}

	public void addListenerOnButton() {
		 
		final Context context = this;
 
		button2 = (Button) findViewById(R.id.button2);
 
		button2.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, AppCaloriasActivity.class);
                            startActivity(intent);   
 
			}
 
		});
		
	}		 

}

 