package com.example.easy_slim_beta;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYStepMode;

import easy_slim_beta.entities.UserProfile;

public class InfoActivity extends Activity{
	SharedPreferences sharedPref;
	UserProfile profile = new UserProfile();
	private List<Double> imcList = new ArrayList<Double>();
	private List<Double> imcNormal = new ArrayList<Double>();
	private List<Double> imcThin = new ArrayList<Double>();
	private List<Double> imcVeryThin = new ArrayList<Double>();
	private List<Double> imcfat = new ArrayList<Double>();
	private List<Double> imcObese = new ArrayList<Double>();
    private XYPlot graficaImc;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imc);		
		load();
		loadImc();
		setContent();
		paintGraph();
	}	
	
	private void paintGraph() {
		// initialize our XYPlot reference:
        graficaImc = (XYPlot) findViewById(R.id.mySimpleXYPlot);
        
        //AÑADE COLORES A LOS LIMITES
        XYSeries serieslimit = new SimpleXYSeries(
                imcNormal,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Normal");                             // Set the display title of the series
        PointLabelFormatter pointlimit = new PointLabelFormatter(0);
        
        XYSeries seriesThinlimit = new SimpleXYSeries(
                imcThin,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Delgado");                             // Set the display title of the series

        XYSeries seriesVeryThinlimit = new SimpleXYSeries(
                imcVeryThin,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Muy delgado");        
        XYSeries seriesObeselimit = new SimpleXYSeries(
                imcObese,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Obeso");

        XYSeries seriesFatlimit = new SimpleXYSeries(
                imcfat,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Sobrepeso");        
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter seriesLimitFormat = new LineAndPointFormatter(
                Color.rgb(127, 255, 0),                   // line color
                null,                   // point color
                Color.rgb(127, 255, 0),
                pointlimit);                                  // fill color (none)

        PointLabelFormatter pointbadlimit = new PointLabelFormatter(0);
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter seriesVeryBadLimitFormat = new LineAndPointFormatter(
                Color.rgb(255, 99, 71),                   // line color
                null,                  // point color
                Color.rgb(255, 99, 71),
                pointbadlimit);                                  // fill color (none)
        
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter seriesBadLimitFormat = new LineAndPointFormatter(
                Color.rgb(255,165,0),                   // line color
                null,                  // point color
                Color.rgb(255, 165, 0),
                pointbadlimit);
        
        // AÑADE LA LINEA DEL ARREGLO
        XYSeries series1 = new SimpleXYSeries(
                imcList,          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Imc");                             // Set the display title of the series
         
        PointLabelFormatter point = new PointLabelFormatter(0);
        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 0, 139),                   // line color
                Color.rgb(0, 0, 0),                   // point color
                null,
                point);                                  // fill color (none)
 
        // add a series' to the xyplot:
        graficaImc.addSeries(seriesObeselimit, seriesVeryBadLimitFormat);
        graficaImc.addSeries(seriesFatlimit, seriesBadLimitFormat);
        graficaImc.addSeries(serieslimit, seriesLimitFormat);
        graficaImc.addSeries(seriesThinlimit, seriesBadLimitFormat);
        graficaImc.addSeries(seriesVeryThinlimit, seriesVeryBadLimitFormat);
        graficaImc.addSeries(series1, series1Format);
        //set domain properties
        graficaImc.setDomainStep(XYStepMode.INCREMENT_BY_VAL,1);
        graficaImc.setDomainLabel("Medicion");        
        graficaImc.getGraphWidget().getDomainLabelPaint().setTextSize(20);
        //graficaImc.getDomainLabelWidget().setSize(new SizeMetrics(20, SizeLayoutType.ABSOLUTE, 20, SizeLayoutType.ABSOLUTE));
        //set range propeties
        graficaImc.setRangeStep(XYStepMode.INCREMENT_BY_VAL,10);
        graficaImc.setRangeBoundaries(10, 40, BoundaryMode.FIXED);
        graficaImc.setRangeLabel("IMC");
        graficaImc.getGraphWidget().getRangeLabelPaint().setTextSize(20);    
        
        graficaImc.setTitle("historial");
        // reduce the number of range labels
        //graficaImc.setTicksPerRangeLabel(3);
		
	}

	private void loadImc() {
		//read file
		String FILENAME = "ImcHistory";
		String value = "";
		FileInputStream fis;
		try {
			fis = openFileInput(FILENAME);
			byte[] input = new byte[fis.available()];
		    while(fis.read(input) != -1){
		      	value += new String(input);
			}
			fis.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		List<String> lista = Arrays.asList(value.split("&"));		
//		lista.remove("");
		
		for(int i=1;i<lista.size();i++){			
			imcList.add(Double.parseDouble(lista.get(i)));
			imcNormal.add((double) 25);
			imcThin.add((double) 18.45);
			imcVeryThin.add((double) 17);
			imcObese.add((double) 40);
			imcfat.add((double) 30);
		}
		
	}

	public void load (){
		sharedPref = getSharedPreferences(getString(R.string.user_profile),0);
		String name = sharedPref.getString(getString(R.string.name), "");
		int year = sharedPref.getInt(getString(R.string.year), 0);
		int month = sharedPref.getInt(getString(R.string.month), 0);
		int day = sharedPref.getInt(getString(R.string.day), 0);
		float height = sharedPref.getFloat(getString(R.string.height), 0);
		float weight = sharedPref.getFloat(getString(R.string.weight), 0);
		
		profile.set(name, year, month, day, height, weight);		
	}

	private void setContent() {
		DecimalFormat formImc = new DecimalFormat("0.0");
		DecimalFormat formHeight = new DecimalFormat("0");
	     
		//put info of user
		TextView heightview = (TextView) findViewById(R.id.heightInfo);
		heightview.setText(formHeight.format(profile.getHeight()));
		TextView weightview = (TextView) findViewById(R.id.weightInfo);
		weightview.setText(formHeight.format(profile.getWeight()));
		TextView imcview = (TextView) findViewById(R.id.imcInfo);		
		imcview.setText(formImc.format(profile.getImc()));
		
		//get health info according to the user
		if(profile.getImc()<=18.49){
			//set content thin
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.thinhuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_thin);
		}
		else if(profile.getImc()>18.49 && profile.getImc()<=25){
			//set content normal
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.normalhuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_normal);
		}
		else{
			//set content fat
			ImageView image = (ImageView) findViewById(R.id.imageInfo);
			image.setImageResource(R.drawable.fathuman);
			
			TextView fileview = (TextView) findViewById(R.id.textInfo);
			fileview.setText(R.string.info_fat);
		}					
	}



	public void okButton(View view) {
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
	}
}
