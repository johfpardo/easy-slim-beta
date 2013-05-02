package com.example.easy_slim_beta;

import java.io.FileOutputStream;

import easy_slim_beta.entities.UserProfile;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;


public class AppActivity extends Activity {
 
	String test;
	Button button;
	UserProfile perfil = new UserProfile();
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		addListenerOnButton();
	}
   
	
	public void addListenerOnButton() {
 
		final Context context = this;
 
		button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
				//save input into an UserProfile object
				EditText editName = (EditText) findViewById(R.id.editName);
				String name = editName.getText().toString();
				perfil.setName(name);
				EditText editAge = (EditText) findViewById(R.id.editAge);
				String age = editAge.getText().toString();
				perfil.setAge(Integer.parseInt(age));
				EditText editHeight = (EditText) findViewById(R.id.editHeight);
				String height = editHeight.getText().toString();
				perfil.setHeight(Double.parseDouble(height));
				EditText editText = (EditText) findViewById(R.id.editWeight);
				String weight = editText.getText().toString();
				perfil.setWeight(Double.parseDouble(weight));
				
				//persist object in database
				String FILENAME = "profile_file";
				String edad = "$" + String.valueOf(perfil.getAge());
				String altura = "$" +String.valueOf(perfil.getHeight());
				String peso = "$" + String.valueOf(perfil.getWeight());
				FileOutputStream fos;
				try {
					fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
					fos.write(perfil.getName().getBytes());
					fos.write(edad.getBytes());
					fos.write(altura.getBytes());
					fos.write(peso.getBytes());
					fos.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}											
					
			    Intent intent = new Intent(context, AppMenuActivity.class);
                            startActivity(intent);   
 
			}
 
		});
 
	}
 
}