package omeng.bbwhm.com.weixin.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianzl on 2017/11/6.
 */

public class MySQLiteDatabase extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="test.db";
    private static final String TABLE_NAME="User";

    public MySQLiteDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create user if not exists "+TABLE_NAME+"(id integer primary key AUTOINCREMENT,Name text,Age integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
}
