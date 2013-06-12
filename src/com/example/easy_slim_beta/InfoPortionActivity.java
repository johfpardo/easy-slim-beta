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
		setContentView(R.layout.infoporcion);
		
		index = 0;

		Intent i = getIntent();
		String msg = i.getStringExtra("Type");
		
		setPortion(msg, index);
	}
	
	public void setPortion(String msg, int index) {
		TextView t = (TextView) findViewById(R.id.portionText);
		ImageView ri = (ImageView) findViewById(R.id.portionImage);
		
		if(msg.contentEquals("Vegetables") || index == 0){
			setTitle("Hortalizas, Verduras Y Leguminosas Verdes");
			t.setText(getString(R.string.Vegetables));
			ri.setImageResource(R.drawable.r_fruitsandvegetables);
		}
		
		if(msg.contentEquals("Fruits") || index == 1){               
			setTitle("Frutas");
			t.setText(getString(R.string.Fruits));
			ri.setImageResource(R.drawable.r_fruits);
		}
		
		if(msg.contentEquals("Cereals") || index == 2){
			setTitle("Cereales");
			t.setText(getString(R.string.Cereals));
			ri.setImageResource(R.drawable.grains);
		}
		
		if(msg.contentEquals("Roots") || index == 3){
			setTitle("Raíces, Tubérculos Y Plátanos");
			t.setText(getString(R.string.Roots));
			ri.setImageResource(R.drawable.protein);
		}
		
		if(msg.contentEquals("meategg") || index == 4){
			setTitle("Carnes, Huevos, Leguminosas");
			t.setText(getString(R.string.Meat));
			ri.setImageResource(R.drawable.protein);
		}
		
		if(msg.contentEquals("Dairy") || index == 5){
			setTitle("Lacteos");
			t.setText(getString(R.string.Dairy));
			ri.setImageResource(R.drawable.dairy);
		}
		
		if(msg.contentEquals("Sugars") || index == 6){
			setTitle("Azucares y Dulces");
			t.setText(getString(R.string.Sugar));
			ri.setImageResource(R.drawable.bpeach);
		}
		
		if(msg.contentEquals("Fat") || index == 7){
			setTitle("Grasas");
			t.setText(getString(R.string.Fat));
			ri.setImageResource(R.drawable.fathuman);
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
