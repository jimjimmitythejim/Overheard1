package overheardsite.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adrian on 6/13/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "counter.db";
    public static final String TABLE_COUNTER = "counter";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COUNT = "count";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_COUNTER + "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_COUNT + " TEXT " + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTER);
        onCreate(db);
    }

    // add a new row to database
    public void addCount(Count count) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_COUNT, count.get_count());
    }

}
