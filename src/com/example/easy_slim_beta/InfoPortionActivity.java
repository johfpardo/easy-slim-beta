package com.example.easy_slim_beta;

import easy_slim_beta.swipe.SwipeGestureDetector;
import easy_slim_beta.swipe.Swipeable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoPortionActivity extends Activity implements Swipeable{
	
	private int index = 0;
	// variable for gesture detector
	@SuppressWarnings("deprecation")
	GestureDetector gestureDetector = new GestureDetector(new SwipeGestureDetector(this));
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infoportion);
		
		//index = 0;

		Intent i = getIntent();
		String msg = i.getStringExtra("Type");
		
		setPortion(msg, index);
		// message for user's navigation
		Toast.makeText(this, getString(R.string.navigate), Toast.LENGTH_LONG).show();
	}
	
	// let the user navigate with gestures on screen
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) return true;
		return super.onTouchEvent(event);
	}
	
	
	public void onLeftSwipe(View view) {
		String msg = "Type";
		index = (index == 0) ? 7 : index-1;
		findViewById(R.id.portion_layout).setAnimation(
				AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
		findViewById(R.id.portion_layout).setAnimation(
				AnimationUtils.loadAnimation(this, R.anim.slide_out_right));
		setPortion(msg, index);		
	}


	public void onRightSwipe(View view) {
		String msg = "Type";		
		index = (index == 7) ? 0 : index+1;
		findViewById(R.id.portion_layout).setAnimation(
				AnimationUtils.loadAnimation(this, R.anim.slide_in_left));
		findViewById(R.id.portion_layout).setAnimation(
				AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
		setPortion(msg, index);
	}
	
	public void setPortion(String msg, int index) {
		TextView t = (TextView) findViewById(R.id.portionText);
		ImageView ri = (ImageView) findViewById(R.id.foodImage);
		ImageView rj = (ImageView) findViewById(R.id.portionImage);
		
		String s = "\nTamaño Porcion: ";
		
		if(msg.contentEquals("Vegetables") || index == 0){
			setTitle("Hortalizas, Verduras Y Leguminosas Verdes");
			t.setText(getString(R.string.Vegetables) + s);
			ri.setImageResource(R.drawable.r_vegetables2);
			rj.setImageResource(R.drawable.vegetables);
		}
		
		if(msg.contentEquals("Cereals") || index == 1){
			setTitle("Cereales");
			t.setText(getString(R.string.Cereals) + s);
			ri.setImageResource(R.drawable.r_cereals);
			rj.setImageResource(R.drawable.cereals);
		}
		
		if(msg.contentEquals("Fruits") || index == 2){               
			setTitle("Frutas");
			t.setText(getString(R.string.Fruits) + s);
			ri.setImageResource(R.drawable.r_fruits2);
			rj.setImageResource(R.drawable.fruits);
		}
				
		if(msg.contentEquals("Roots") || index == 3){
			setTitle("Raices, Tuberculos Y Platanos");
			t.setText(getString(R.string.Roots) + s);
			ri.setImageResource(R.drawable.r_roots);
			rj.setImageResource(R.drawable.roots);
		}
		
		if(msg.contentEquals("meategg") || index == 4){
			setTitle("Carnes, Huevos, Leguminosas");
			t.setText(getString(R.string.Meat) + s);
			ri.setImageResource(R.drawable.r_protein);
			rj.setImageResource(R.drawable.protein);
		}
		
		if(msg.contentEquals("Dairy") || index == 5){
			setTitle("Lacteos");
			t.setText(getString(R.string.Dairy)  + s);
			ri.setImageResource(R.drawable.r_dairy);
			rj.setImageResource(R.drawable.dairy);
		}
		
		if(msg.contentEquals("Sugars") || index == 6){
			setTitle("Azucares y Dulces");
			t.setText(getString(R.string.Sugar) + s);
			ri.setImageResource(R.drawable.r_sugars);
			rj.setImageResource(R.drawable.sugars);
		}
		
		if(msg.contentEquals("Fat") || index == 7){
			setTitle("Grasas");
			t.setText(getString(R.string.Fat) + s);
			ri.setImageResource(R.drawable.r_fat);
			rj.setImageResource(R.drawable.fat);
		}		
	}
}
