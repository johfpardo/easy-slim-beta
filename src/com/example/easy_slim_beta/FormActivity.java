package com.example.easy_slim_beta;

import java.util.Calendar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.view.View.OnClickListener;


public class FormActivity extends Activity {
 
	Button pickDate;
	Button button;
	String name;
	int year;
	int month;
	int day;
	float height;
	float weight;
	boolean sex;
	final int DATE_DIALOG_ID = 0;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		addListenerOnButton();			
	}
   
	
	
	public void addListenerOnButton() {
 
		final Context context = this;
 
		pickDate = (Button) findViewById(R.id.pickDate);
		button = (Button) findViewById(R.id.button1);
		
		
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
				save();
			    Intent intent = new Intent(context,MainMenuActivity.class);
                            startActivity(intent);   
 
			}
 
		});
 
		//This will show us the current date
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
	}
	
	//Actions called every time button "Set" is clicked
	DatePickerDialog.OnDateSetListener mDateSetListener =
	   new DatePickerDialog.OnDateSetListener() {
	 
		@Override
		public void onDateSet(DatePicker view, int yearOf, int monthOfYear, int dayOfMonth) {
	            year = yearOf;
	            month = monthOfYear;
	            day = dayOfMonth;
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
	
	@SuppressLint("InlinedApi")
	public void save(){
		
		//save input in a SharedPreferences file called UserProfile
		
        EditText editName = (EditText) findViewById(R.id.editTextName);
        name = editName.getText().toString();
        EditText editHeight = (EditText) findViewById(R.id.editTextHeight);
        height = Float.parseFloat(editHeight.getText().toString());
        EditText editText = (EditText) findViewById(R.id.editTextWeigth);
        weight = Float.parseFloat(editText.getText().toString());
		RadioButton radioSex = (RadioButton)findViewById(R.id.radioWoman);
        sex = radioSex.isChecked();
        
		SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.user_profile),Context.MODE_MULTI_PROCESS);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(getString(R.string.name),name);
		editor.putInt(getString(R.string.year), year);
		editor.putInt(getString(R.string.month), month);
		editor.putInt(getString(R.string.day), day);
		editor.putFloat(getString(R.string.height), height);
		editor.putFloat(getString(R.string.weight), weight);
		editor.putBoolean(getString(R.string.sex), sex);
		editor.commit();
	}
 
}

