package com.example.easy_slim_beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class VitaminasListActivity extends Activity {
	
	protected AdView adView;
	private ListView lv1;
	private String lv_arr[]={"  Vitamina A  ","  Vitamina D  ","  Vitamina E  ","  Vitamina K  ","  Vitamina C  ","  Vitamina B1 o Tiamina  ","  Vitamina B2 o Riboflavina  ","  Vitamina B3 o Niacina  ",
			"  Vitamina B6 o Piridoxina  ","  Vitamina B9 o Ácido fólico  ","  Vitamina B12 o Cobalamina  ","  Vitamina H o Biotina  ",
			"  Acido Pantotético  "};


@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.vitaminas);
	adView = (AdView)findViewById(R.id.ad);
	adView.loadAd(new AdRequest());
	
	 lv1=(ListView)findViewById(R.id.listview);

     // By using setAdpater method in listview we an add string array in list.

     lv1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));


     lv1.setOnItemClickListener(new OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View view,
       int position, long id) {
 	  
 	  switch (position) {
       case 0:
        Intent newActivity0 = new Intent(VitaminasListActivity.this,MainMenuActivity.class);     
        startActivity(newActivity0);
       break;
       case 1:
        Intent newActivity1 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
        startActivity(newActivity1);
       break;
       case 2:
           Intent newActivity2 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity2);
          break;
       case 3:
           Intent newActivity3 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity3);
          break;
       case 4:
           Intent newActivity4 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity4);
          break;
       case 5:
           Intent newActivity5 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity5);
          break;
       case 6:
           Intent newActivity6 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity6);
          break;
       case 7:
           Intent newActivity7 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity7);
          break;
       case 8:
           Intent newActivity8 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity8);
          break;  
       case 9:
           Intent newActivity9 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity9);
          break;  
       case 10:
           Intent newActivity10 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity10);
          break;  
       case 11:
           Intent newActivity11 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity11);
          break;  
       case 12:
           Intent newActivity12 = new Intent(VitaminasListActivity.this,PorsionesActivity.class);     
           startActivity(newActivity12);
          break;      
       default:
	     
	    }
   }
 });

 }

}
