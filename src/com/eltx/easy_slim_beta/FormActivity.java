package com.eltx.easy_slim_beta;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;

import com.eltx.easy_slim_beta.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FormActivity extends Activity {
 
	SharedPreferences sharedPref;
	SharedPreferences.Editor editor;
	TextView dateDisplay;
	Button pickDate;
	Button button;
	String name;
	int year;
	int month;
	int day;
	float height;
	float weight;
	final int DATE_DIALOG_ID = 0;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR) - 18; //Mayores de 18 años 
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
		addListenerOnButton();
	}
   
	
	
	public void addListenerOnButton() {
 
		final Context context = this;
 
		dateDisplay = (TextView) findViewById(R.id.textViewDate);
		pickDate = (Button) findViewById(R.id.pickDate);
		button = (Button) findViewById(R.id.button1);
		load();
		
		
		pickDate.setOnClickListener(new OnClickListener() {

			
			DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
				public void onDateSet(DatePicker view, int yearOf, int monthOfYear, int dayOfMonth) {
					year = yearOf;
					month = monthOfYear;
					day = dayOfMonth;
					updateDate();
				}
			};
			
			final Calendar c = Calendar.getInstance();		
			DatePickerDialog dpd = new DatePickerDialog(
					context,mDateSetListener, c.get(Calendar.YEAR)-18, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)) {
				
				public void onDateChanged(DatePicker view,int year, int month, int day){
					int maxYear = c.get(Calendar.YEAR)-18;
					int minYear = maxYear-70;
					
					if(year > maxYear) {
						Toast.makeText(getApplicationContext(), "Año maximo permitido", Toast.LENGTH_SHORT).show();
						year = maxYear;
						view.updateDate(year, month, day);
					} else if(year < minYear) {
						Toast.makeText(getApplicationContext(), "Año minimo permitido", Toast.LENGTH_SHORT).show();
						year = minYear;
						view.updateDate(year, month, day);
					}
			    }
			};
			
			@Override
			public void onClick(View arg0) {
				dpd.show();
			}
			
		});
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				try{
					save();					
					finish();               
					}
					catch(Exception e){
						//show dialog
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
								context);								
				 
							// set dialog message
							alertDialogBuilder
								.setMessage(getString(R.string.dialogMessage))
								.setCancelable(false)
								.setPositiveButton(getString(R.string.accept),new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int id) {

									}
								  });
								
								// create alert dialog
								AlertDialog alertDialog = alertDialogBuilder.create();
				 
								// show it
								alertDialog.show();

						// Showing Alert Message
					}
 
			}
 
		});
		
	}
	
	private void updateDate() {
	    dateDisplay.setText(
	        new StringBuilder()
	        //Constant Month is 0 based so we have to add 1
	       .append("Mes - Dia - Año: ").append(month + 1).append("-")
	       .append(day).append("-").append(year).append(" "));
	}
	

	public void load (){
		sharedPref = getSharedPreferences(getString(R.string.user_profile),0);
		name = sharedPref.getString(getString(R.string.name), "");
		year = sharedPref.getInt(getString(R.string.year), 0);
		month = sharedPref.getInt(getString(R.string.month), 0);
		day = sharedPref.getInt(getString(R.string.day), 0);
		height = sharedPref.getFloat(getString(R.string.height), 0);
		weight = sharedPref.getFloat(getString(R.string.weight), 0);
		if(year!=0){
			EditText editName = (EditText) findViewById(R.id.editTextName);
			editName.setText(name);
			updateDate();
			EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
			editHeight.setText(Integer.toString((int)height));
			EditText editWeight= (EditText) findViewById(R.id.editTextWeigth);
			editWeight.setText(Integer.toString((int)weight));
		}
	}
	
	public void save(){
		
        EditText editName = (EditText) findViewById(R.id.editTextName);
        name = editName.getText().toString();
        EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
        height = Float.parseFloat(editHeight.getText().toString());
        EditText editWeight= (EditText) findViewById(R.id.editTextWeigth);
        weight = Float.parseFloat(editWeight.getText().toString());
        int maxHeight = 250;
        int maxWeight = 550;
        int minHeight = 60;
        int minWeight = 35;
        
        if(height > maxHeight || height < minHeight){
        	Toast.makeText(getApplicationContext(), "Altura fuera del rango permitido, el cual es 60 - 250 cm", Toast.LENGTH_SHORT).show();
        	throw new RuntimeException();
        }else if(weight > maxWeight || weight < minWeight){
        	Toast.makeText(getApplicationContext(), "Peso fuera del rango permitido, el cual es 550 - 35 Kg", Toast.LENGTH_SHORT).show();
        	throw new RuntimeException();
        }else{
        	saveImc(height, weight);
            //save input in a SharedPreferences file called UserProfile
              sharedPref = getSharedPreferences(getString(R.string.user_profile),0);
      		editor = sharedPref.edit();
      		editor.putString(getString(R.string.name),name);
      		editor.putInt(getString(R.string.year), year);
      		editor.putInt(getString(R.string.month), month);
      		editor.putInt(getString(R.string.day), day);
      		editor.putFloat(getString(R.string.height), height);
      		editor.putFloat(getString(R.string.weight), weight);
      		editor.commit();
        }
	}



	private void saveImc(float height2, float weight2) {
		// TODO Auto-generated method stub
		float imc2 = weight2/((height2/100)*(height2/100));
		//persist object in database
		DecimalFormat formImc = new DecimalFormat("0.0");
		String FILENAME = "ImcHistory";		
		String imcText = "&" + formImc.format(imc2);
		FileOutputStream fos;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_APPEND);
			fos.write(imcText.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
}

