package com.example.easy_slim_beta;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import easy_slim_beta.entities.UserProfile;

public class InfoActivity extends Activity{
	protected AdView adView;
	UserProfile profile = new UserProfile();
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imc);
		adView = (AdView)findViewById(R.id.ad);
		adView.loadAd(new AdRequest());
		//test values
		profile.setName("test");
		profile.setAge(12);
		profile.setHeight(1000);
		profile.setWeight(20);
		profile.calculateImc();
		setContent();		
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
