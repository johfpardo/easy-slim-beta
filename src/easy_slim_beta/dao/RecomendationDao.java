package easy_slim_beta.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import easy_slim_beta.entities.Recomendation;

public class RecomendationDao {
	SQLiteDatabase db;
	public RecomendationDao(Context context) {
		db = new EasySlimDB(context).open();
	}
	
	public List<Recomendation> getRecomendationForBMI(float bmi) {
		String typeOfRecomedation = "";
		if(bmi<18.5) typeOfRecomedation = "Underweight";
		else if(bmi>=18.5 && bmi<=25) typeOfRecomedation = "Normal";
		else typeOfRecomedation = "Overweight";
		
		List<Recomendation> list = new ArrayList<Recomendation>();
		
		Cursor cursor = db.query(EasySlimDB.RECOMENDATION_TABLE_NAME, new String[] {"textRecomendation","imageName"},
				"typeOfRecomedation='" + typeOfRecomedation + "'", null, null, null, null);
		if (cursor.moveToFirst()) do {
			list.add( new Recomendation(cursor.getString(0), cursor.getString(1)) );
		} while (cursor.moveToNext());
		if (cursor != null && !cursor.isClosed()) cursor.close();
		db.close();
		return list;
	}
}