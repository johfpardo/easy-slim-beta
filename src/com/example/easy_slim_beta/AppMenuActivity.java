package com.example.easy_slim_beta;

import java.io.FileInputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
 
public class AppMenuActivity extends Activity {
 
	Button button2;
	Button button3;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		addListenerOnButton();
		
		
		//read file
		String FILENAME = "profile_file";
		String value = "";
		FileInputStream fis;
		try {
			fis = openFileInput(FILENAME);
			byte[] input = new byte[fis.available()];
            while(fis.read(input) != -1){
            	value += new String(input);
            }
		fis.close();
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TextView fileview = (TextView) findViewById(R.id.fileView);
		fileview.setText(value);
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

 