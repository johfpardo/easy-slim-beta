package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import easy_slim_beta.entities.UserProfile;

public class InfoActivity extends Activity{
	SharedPreferences sharedPref;
	UserProfile profile = new UserProfile();
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imc);		
		load();
		setContent();		
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
		
		profile.set(name, year, month, day, height, weight, sex);		
	}

	private void setContent() {
		// TODO Auto-generated method stub
		if(profile.getImc()<=18.49){
			//set content thin
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.thinhuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_thin);
		}
		else if(profile.getImc()>18.49 && profile.getImc()<=25){
			//set content normal
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.normalhuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_normal);
		}
		else{
			//set content fat
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.fathuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_fat);
		}					
	}



	public void okButton(View view) {
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
	}
}
