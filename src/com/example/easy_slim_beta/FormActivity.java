package com.example.easy_slim_beta;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


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
		addListenerOnButton();			
	}
   
	
	
	public void addListenerOnButton() {
 
		final Context context = this;
 
		dateDisplay = (TextView) findViewById(R.id.textViewDate);
		pickDate = (Button) findViewById(R.id.pickDate);
		button = (Button) findViewById(R.id.button1);
		updateDate();
		
		
		pickDate.setOnClickListener(new OnClickListener() {


			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			} 
			
		});
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				try{
					save();
					Intent intent = new Intent(context,MainMenuActivity.class);
	                startActivity(intent);               
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
 
		//This will show us the current date
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
	}
	
	private void updateDate() {
	    dateDisplay.setText(
	        new StringBuilder()
	        //Constant Month is 0 based so we have to add 1
	       .append("Mes - Día - Año: ")
	       .append(month + 1).append("-")
	       .append(day).append("-")
	       .append(year).append(" "));
	}
	
	//Actions called every time button "Set" is clicked
	DatePickerDialog.OnDateSetListener mDateSetListener =
	   new DatePickerDialog.OnDateSetListener() {
	 
		@Override
		public void onDateSet(DatePicker view, int yearOf, int monthOfYear, int dayOfMonth) {
	            year = yearOf;
	            month = monthOfYear;
	            day = dayOfMonth;
	            updateDate();
	     }

	};
	
	@Override
	protected Dialog onCreateDialog(int id) {
	    switch (id) {
	         case DATE_DIALOG_ID:
	               return new DatePickerDialog(this, mDateSetListener, year, month, day);
	     }
	     return null;
	}
	
	//private void check(){
		//check if there are dates of user in the app yet
	//}
	
	public void save(){
		
		//save input in a SharedPreferences file called UserProfile
		
        EditText editName = (EditText) findViewById(R.id.editTextName);
        name = editName.getText().toString();
        EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
        height = Float.parseFloat(editHeight.getText().toString());
        EditText editText = (EditText) findViewById(R.id.editTextWeigth);
        weight = Float.parseFloat(editText.getText().toString());
        
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

