package app.com.example.android.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.deleteDatabase("Apartment.db");
        ApartmentDbHelper mDBHelper = new ApartmentDbHelper(getApplicationContext());
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues vals = new ContentValues();
        vals.put("address", "222 Road St.");
        vals.put("bed", 3);
        vals.put("bath", 2);
        vals.put("price", 700);
        vals.put("date", "August 12, 2015");

        long newRowId;
        newRowId = db.insert("info", null, vals);

        ContentValues vals2 = new ContentValues();
        vals2.put("address", "2020 Mission Blvd");
        vals2.put("bed", 1);
        vals2.put("bath", 1);
        vals2.put("price", 500);
        vals2.put("date", "August 1, 2015");

        long newRowId2;
        newRowId2 = db.insert("info", null, vals2);

        ContentValues vals3 = new ContentValues();
        vals3.put("address", "2024 Turring Ave");
        vals3.put("bed", 4);
        vals3.put("bath", 2);
        vals3.put("price", 1100);
        vals3.put("date", "August 8, 2015");

        long newRowId3;
        newRowId3 = db.insert("info", null, vals3);


        db = mDBHelper.getReadableDatabase();
        String[] columns = { "address" };
        String predicate = "price < ?";
        String[] predicate_values = { "1000" };
        String orderBy = "price ASC";
        Cursor c = db.query("info", columns, predicate, predicate_values, null, null, orderBy);
        c.moveToFirst();
        String addr = c.getString(c.getColumnIndex("address"));
        Log.v("ADDR_TAG", addr);
        c.moveToNext();
        String addr2 = c.getString(c.getColumnIndex("address"));
        Log.v("ADDR_TAG", addr2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
