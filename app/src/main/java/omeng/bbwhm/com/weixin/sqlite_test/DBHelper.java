package omeng.bbwhm.com.weixin.sqlite_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianzl on 2017/11/6.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String TABLE_NAME = "User";// 表名
    public static String FIELD_NAME = "Name";// 列名
    public static String  FIELD_AGE= "Age";// 列名


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user (id integer primary key AUTOINCREMENT,"+
              "name text, age integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
    public Cursor select(String sql, String[] selectionArgs){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorr = db.rawQuery(sql, selectionArgs);
        return cursorr;
    }
    public long insert(String table, ContentValues cv){
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(table,null, cv);
    }
    public int deleteRecode(String table, String where, String[] whereArgs){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(table, where, whereArgs);
        db.close();
        return result;
    }
    public int deleteAllRecode(String table){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(table, null, null);
        return result;
    }
    public int updateRecode(String table, ContentValues cv, String where, String[] whereArgs){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.update(table, cv, where, whereArgs);
        return result;
    }
    public Cursor selectRecode(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursorr = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);

        return cursorr;
    }

}
