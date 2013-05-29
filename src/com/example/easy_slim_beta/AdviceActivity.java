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
	private List<Recomendation> recomendations;
	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advice);
		recomendations = new RecomendationDao(this).getRecomendationForBMI(MainMenuActivity.user.getImc());
		index=0;
		setRecomendation();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.advice, menu);
		return true;
	}
	
	public void setRecomendation() {
		ImageView ri = (ImageView) findViewById(R.id.recomendationImage);
		TextView rt = (TextView) findViewById(R.id.recomendationText);
		TextView nr = (TextView) findViewById(R.id.numberRecomendation);
		try {
			ri.setImageResource(getResources().getIdentifier(
				recomendations.get(index).getImageName(), "drawable", getPackageName()));
			rt.setText(recomendations.get(index).getTextRecomendation());
			nr.setText("Recomendacion "+(index+1)+" de "+recomendations.size());
		} catch(Exception e) {
			rt.setText("No se encontraron Recomendaciones para usted.");
		}
	}
	
	public void nextRecomendation(View view) {
		index++;
		if(index==recomendations.size()) index=0;
		setRecomendation();
	}
	
	public void prevRecomendation(View view) {
		index--;
		if(index==-1) index+=recomendations.size();
		setRecomendation();
	}
}