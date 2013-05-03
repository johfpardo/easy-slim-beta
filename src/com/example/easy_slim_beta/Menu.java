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
import easy_slim_beta.entities.UserProfile;


public class Menu extends Activity {
	final Context context = this;
	UserProfile perfil = new UserProfile();
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		//read file
		String FILENAME = "profile_file";
		String fileString = "";
 		FileInputStream fis;
		try {
			fis = openFileInput(FILENAME);
			byte[] input = new byte[fis.available()];
            while(fis.read(input) != -1){
            	fileString += new String(input);
            }
		fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] result = fileString.split(":");
		perfil.setName(result[0]);
		perfil.setAge(Integer.parseInt(result[1]));
		perfil.setHeight(Double.parseDouble(result[2]));
		perfil.setWeight(Double.parseDouble(result[3]));
		perfil.setImc(Double.parseDouble(result[4]));
		TextView fileview = (TextView) findViewById(R.id.fileView);
		fileview.append(perfil.getName());
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {
		button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(context, AppRecomendacionActivity.class);
                startActivity(intent); 
			}
		});
	}
}
