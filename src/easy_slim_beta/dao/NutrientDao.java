package easy_slim_beta.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import easy_slim_beta.entities.Nutrient;
import easy_slim_beta.entities.Recomendation;



public class NutrientDao {
	SQLiteDatabase db;
	public NutrientDao(Context context) {
		db = new EasySlimDB(context).open();
	}	
	
	public List<Nutrient> getNutrients(String typeOfNutrient) {		
		
		List<Nutrient> nutrients = new ArrayList<Nutrient>();
		Cursor cursor = db.query(EasySlimDB.NUTRIENT_TABLE_NAME, new String[] {"name","description", "foodList", "typeOfNutrient"},
				"typeOfNutrient='" + typeOfNutrient + "'", null, null, null, null);
		if (cursor.moveToFirst()) do {
			nutrients.add( new Nutrient(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)) );
		} while (cursor.moveToNext());
		if (cursor != null && !cursor.isClosed()) cursor.close();
		db.close();
		return nutrients;
	}
	
	public Nutrient getNutrientByName(String name){
		
		Nutrient nutrient = new Nutrient("","","",""); 
		Cursor cursor = db.query(EasySlimDB.NUTRIENT_TABLE_NAME, new String[] {"name","description", "foodList", "typeOfNutrient"},
				"name='" + name + "'", null, null, null, null);
		if (cursor.moveToFirst()) do {
			nutrient = new Nutrient(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)) ;
		} while (cursor.moveToNext());
		if (cursor != null && !cursor.isClosed()) cursor.close();
		db.close();
		return nutrient;
	}
}
