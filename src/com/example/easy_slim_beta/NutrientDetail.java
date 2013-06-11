package com.example.easy_slim_beta;

import java.util.List;

import easy_slim_beta.dao.NutrientDao;
import easy_slim_beta.entities.Nutrient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class NutrientDetail extends Activity {

	private Nutrient nutrients;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nutrient_detail);
		
		//get nutrient to load
		Intent intent = getIntent();
		String message = intent.getStringExtra(CaloriasActivity.EXTRA_MESSAGE);		
		nutrients = new NutrientDao(this).getNutrientByName(message);
		
		setNutrientContent();
	}

	private void setNutrientContent() {
		// TODO Auto-generated method stub
		TextView nameView = (TextView) findViewById(R.id.mineralNameView);		
		nameView.setText(nutrients.getName());
		TextView descriptionView = (TextView) findViewById(R.id.mineralDescriptionView);		
		descriptionView.setText(nutrients.getDescription());
		TextView foodView = (TextView) findViewById(R.id.mineralFoodView);		
		foodView.append("\n");
		foodView.append(nutrients.getFoodList());			
		
	}

}
