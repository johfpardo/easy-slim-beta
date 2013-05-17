package com.example.easy_slim_beta;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import easy_slim_beta.dao.RecomendationDao;
import easy_slim_beta.entities.Recomendation;

public class AdviceActivity extends Activity {
	List<Recomendation> r;
	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advice);
		
		r = (new RecomendationDao()).getRecomendationForBMI(0);
		index=0;
		setRecomendation(index);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.advice, menu);
		return true;
	}
	
	public void setRecomendation(int index) {
		ImageView iv = (ImageView) findViewById(R.id.recomendationImage);
		TextView tv= (TextView) findViewById(R.id.recomendationText);
		
		iv.setImageResource(getResources()
				.getIdentifier(r.get(index).getImageName(), "drawable", getPackageName()));
		tv.setText(r.get(index).getTextRecomendation());
	}
	
	public void nextRecomendation(View view) {
		index++;
		if(index==r.size()) index=0;
		setRecomendation(index);
	}
	
	public void prevRecomendation(View view) {
		index--;
		if(index==-1) index=r.size()-1;
		setRecomendation(index);
	}
}