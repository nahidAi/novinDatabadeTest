package dtabase.novin.com.databaseproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final String DBNAME = "DBNAME";
    public static final String TABLENAME = "TABLENAME";

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String FAMILY = "FAMILY";
    public static final String PHONE = "PHONE";
    public static final String DATE = "DATE";

    public static final String Createtable = "CREATE TABLE " + TABLENAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT,"
            + FAMILY + " TEXT,"
            + PHONE + " TEXT,"
            + DATE + " TEXT);";

    public Database(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Createtable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void InsertData(Data data) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, data.getName());
        values.put(FAMILY, data.getFamily());
        values.put(PHONE, data.getPhone());
        values.put(DATE, data.getDate());

        database.insert(TABLENAME, null, values);
        database.close();
    }
    public ArrayList<Data> ShowData()
    {
        ArrayList<Data> data = new ArrayList<>();
        String query = "SELECT * FROM " + TABLENAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Data modelItem = new Data();
                modelItem.setId(Integer.parseInt(cursor.getString(0)));
                modelItem.setName(cursor.getString(1));
                modelItem.setFamily(cursor.getString(2));
                modelItem.setPhone(cursor.getString(3));
                modelItem.setDate(cursor.getString(4));

                data.add(modelItem);
            }
            while (cursor.moveToNext());
        }

        return data;
    }
    public void Delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLENAME,"id = " + id,null);


    }
    public  void Update(Data data,int id){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, data.getName());
        values.put(FAMILY, data.getFamily());
        values.put(PHONE, data.getPhone());
        values.put(DATE, data.getDate());
        database.update(TABLENAME,values,"id = " + id,null);
        database.close();

    }
}
