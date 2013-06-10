package com.example.easy_slim_beta;

import java.util.List;

//import easy_slim_beta.entities.Portion;
import easy_slim_beta.entities.Recomendation;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPortionActivity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infoporcion);

		Intent i = getIntent();
		String msg = i.getStringExtra("Type");
		
		setPortion(msg);
	}
	
	public void setPortion(String msg) {
		TextView t = (TextView) findViewById(R.id.portionText);
		ImageView ri = (ImageView) findViewById(R.id.portionImage);
		
		if(msg.contentEquals("Vegetables")){
			t.setText(getString(R.string.Vegetables));
			ri.setImageResource(R.drawable.vegetables);
		}
		
		if(msg.contentEquals("Fruits")){
			t.setText(getString(R.string.Fruits));
			ri.setImageResource(R.drawable.fruits);
		}
		
		if(msg.contentEquals("Cereals")){
			t.setText(getString(R.string.Cereals));
			ri.setImageResource(R.drawable.grains);
		}
		
		if(msg.contentEquals("Roots")){
			t.setText(getString(R.string.Roots));
			ri.setImageResource(R.drawable.protein);
		}
		
		if(msg.contentEquals("meategg")){
			t.setText(getString(R.string.Meat));
			ri.setImageResource(R.drawable.protein);
		}
		
		if(msg.contentEquals("Dairy")){
			t.setText(getString(R.string.Dairy));
			ri.setImageResource(R.drawable.dairy);
		}
		
		if(msg.contentEquals("Sugars")){
			t.setText(getString(R.string.Sugar));
			ri.setImageResource(R.drawable.bpeach);
		}
		
		if(msg.contentEquals("Fat")){
			t.setText(getString(R.string.Fat));
			ri.setImageResource(R.drawable.fathuman);
		}		
	}
}
