package easy_slim_beta.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class EasySlimDB {
	private static final int DB_VERSION = 1;
	private static final String DB_NAME = "easy-slim.db";
	private static final String DB_PATH = "/data/data/com.example.easy_slim_beta/databases/";
	// tables
	public static final String RECOMENDATION_TABLE_NAME = "recomendations";
	public static final String NUTRIENT_TABLE_NAME = "nutrients";
	
	private MyDBOpenHelper openHelper;
	Context context;
	
	public EasySlimDB(Context context) {
		this.context = context;
		
		SQLiteDatabase checkDB = null;
		try{
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	} catch(SQLiteException e) { }
		
		if(checkDB != null){
			checkDB.close();
		} else this.copy();
	}
	
	private void copy() {
		try {
			File dir = new File(DB_PATH);
			if (!dir.exists()) dir.mkdir();
			InputStream myInput = context.getAssets().open(DB_NAME);
			OutputStream myOutput = new FileOutputStream(DB_PATH + DB_NAME);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer)) > 0) {
				myOutput.write(buffer, 0, length);
			}
			myOutput.flush();
			myOutput.close();
			myInput.close();
		} catch (IOException e) { }
	}
	
	public SQLiteDatabase open() {
		this.openHelper = new MyDBOpenHelper(this.context);
		return this.openHelper.getReadableDatabase();
	}
	
	// SQLiteOpenHelper Class
	private static class MyDBOpenHelper extends SQLiteOpenHelper {
		MyDBOpenHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) { }
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
	}
}