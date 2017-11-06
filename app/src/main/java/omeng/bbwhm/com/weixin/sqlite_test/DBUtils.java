package omeng.bbwhm.com.weixin.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by tianzl on 2017/11/6.
 */

public class DBUtils {

    public static MySQLiteDatabase database;

    private Context context;

    public DBUtils(Context context){
        this.context = context;
        database=new MySQLiteDatabase(context);
    }

    public static void addUser(String name,int age){
        SQLiteDatabase db=database.getWritableDatabase();
        db.beginTransaction();
        db.execSQL("insert into User (Name,age) value("+name+","+age+")");
        db.setTransactionSuccessful();
    }

    public static void delUser(int id){

    }
    public static void Update(int id,String name,int age){

    }

    public static void selUser(String sql){

    }
    public static void selAllUser(){

    }


}
