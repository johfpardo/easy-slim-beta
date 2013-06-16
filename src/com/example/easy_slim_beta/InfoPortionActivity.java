package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPortionActivity extends Activity{
	
	private int index;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infoportion);
		
		index = 0;

		Intent i = getIntent();
		String msg = i.getStringExtra("Type");
		
		setPortion(msg, index);
	}
	
	public void setPortion(String msg, int index) {
		TextView t = (TextView) findViewById(R.id.portionText);
		ImageView ri = (ImageView) findViewById(R.id.foodImage);
		ImageView rj = (ImageView) findViewById(R.id.portionImage);
		
		String s = "\n Tamaño Porción: ";
		
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
			setTitle("Raíces, Tubérculos Y Plátanos");
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
	
	public void next(View view) {
		index++;
		String msg = "Type";
		if(index == 8) index=0;
		setPortion(msg, index);
	}
	
	public void prev(View view) {
		index--;
		String msg = "Type";
		if(index ==-1) index=7;
		setPortion(msg, index);
	}
}
