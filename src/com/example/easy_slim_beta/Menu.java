package com.example.easy_slim_beta;

import java.io.FileInputStream;

import easy_slim_beta.entities.UserProfile;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;


public class Menu extends Activity {
	UserProfile perfil = new UserProfile();
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
		
	}
}
