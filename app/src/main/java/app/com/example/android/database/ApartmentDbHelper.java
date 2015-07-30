package app.com.example.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahaidrey on 7/29/15.
 */
public class ApartmentDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Apartment";
//    public static final String table = "(address TEXT, bed INT, bath DECIMAL(10,5), price DECIMAL(10,5), date DATETIME)";

    public ApartmentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE info ( address TEXT, bed INT, bath INT, price INT, date DATETIME )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // blank for now
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // blank for now
    }
}
