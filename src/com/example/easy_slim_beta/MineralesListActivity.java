package com.example.easy_slim_beta;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

public class MineralesListActivity extends Activity {
	
	protected AdView adView;
	private ListView lv1;
	private String lv_arr[]={"  Calcio  ","  Fósforo  ","  Magnesio  ","  Hierro  ",
			"  Zinc  ","  Yodo  ","  Cobre  "};


@Override
public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.minerales);
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
        Intent newActivity0 = new Intent(MineralesListActivity.this,MainMenuActivity.class);     
        startActivity(newActivity0);
       break;
       case 1:
        Intent newActivity1 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
        startActivity(newActivity1);
       break;
       case 2:
           Intent newActivity2 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
           startActivity(newActivity2);
          break;
       case 3:
           Intent newActivity3 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
           startActivity(newActivity3);
          break;
       case 4:
           Intent newActivity4 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
           startActivity(newActivity4);
          break;
       case 5:
           Intent newActivity5 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
           startActivity(newActivity5);
          break;
       case 6:
           Intent newActivity6 = new Intent(MineralesListActivity.this,PorcionesActivity.class);     
           startActivity(newActivity6);
          break;   
       default:
	     
	    }
   }
 });

 }
	
}


