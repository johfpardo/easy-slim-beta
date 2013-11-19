package com.eltx.easy_slim_beta;

import java.util.List;

import com.eltx.easy_slim_beta.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.*;
import easy_slim_beta.dao.RecomendationDao;
import easy_slim_beta.entities.Recomendation;
import easy_slim_beta.entities.UserProfile;
import easy_slim_beta.swipe.SwipeGestureDetector;
import easy_slim_beta.swipe.Swipeable;

public class AdviceActivity extends Activity  implements Swipeable {
	// list of recommendation 
	private List<Recomendation> recomendations;
	// index or current recommendation
	private int index = 0;
	// variable for gesture detector
	@SuppressWarnings("deprecation")
	GestureDetector gestureDetector = new GestureDetector(new SwipeGestureDetector(this));
	
	UserProfile profile = new UserProfile();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advice);
		load();
		recomendations = new RecomendationDao(this).getRecomendationForBMI(profile.getImc());
		// show the first recommendation
		setRecomendation();
		// message for user's navigation
		Toast.makeText(this, getString(R.string.navigate), Toast.LENGTH_LONG).show();
	}
	
	// let the user navigate with gestures on screen
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) return true;
		return super.onTouchEvent(event);
	}
	
	// set the next recommendation
		@Override
		public void onLeftSwipe(View view) {
			index = (index == 0) ? recomendations.size()-1 : index-1;
			findViewById(R.id.advice_layout).setAnimation(
					AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
			findViewById(R.id.advice_layout).setAnimation(
					AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
			setRecomendation();
		}
		
		// set the previous recommendation
		@Override
		public void onRightSwipe(View view) {
			index = (index == recomendations.size()-1) ? 0 : index+1;
			findViewById(R.id.advice_layout).setAnimation(
					AnimationUtils.loadAnimation(this, R.anim.slide_in_left));
			findViewById(R.id.advice_layout).setAnimation(
					AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
			setRecomendation();
		}
		
		// set the recommendation
	public void setRecomendation() {
		ImageView ri = (ImageView) findViewById(R.id.recomendationImage);
		TextView rt = (TextView) findViewById(R.id.recomendationText);
		TextView nr = (TextView) findViewById(R.id.numberRecomendation);
		try {
			ri.setImageResource(getResources().getIdentifier(
				recomendations.get(index).getImageName(), "drawable", getPackageName()));
			rt.setText(recomendations.get(index).getTextRecomendation());
			nr.setText(getString(R.string.recommendation) + " " + (index+1) + " / " + recomendations.size());
		} catch(Exception e) {
			rt.setText(getString(R.string.recommendationsNotFound));
		}
	}
	
	public void load (){
		SharedPreferences sharedPref;
		sharedPref = getSharedPreferences(getString(R.string.user_profile),0);
		String name = sharedPref.getString(getString(R.string.name), "");
		int year = sharedPref.getInt(getString(R.string.year), 0);
		int month = sharedPref.getInt(getString(R.string.month), 0);
		int day = sharedPref.getInt(getString(R.string.day), 0);
		float height = sharedPref.getFloat(getString(R.string.height), 0);
		float weight = sharedPref.getFloat(getString(R.string.weight), 0);
		
		profile.set(name, year, month, day, height, weight);		
	}
}