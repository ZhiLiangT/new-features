package omeng.bbwhm.com.weixin.sqlite_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import omeng.bbwhm.com.weixin.retrofit2.bean.User;


/**
 * Created by tianzl on 2017/11/6.
 */

public class DBUtils {

    public static DBHelper database;

    public static void addUser(Context context,String name,String age){

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.FIELD_NAME, name);
        cv.put(DBHelper.FIELD_AGE,age);
        database.insert(DBHelper.TABLE_NAME,cv);
    }

    public static void delUser(Context context,int id){

        database.deleteRecode(DBHelper.TABLE_NAME,"id=?",new String[]{""+id});
    }

    public static void updateUser(Context context,int id,String name,String age){


    }

    public static void selUser(String sql){

    }
    public static List<User> selAllUser(Context context){

        List<User> list=new ArrayList<>();
        String[] columns = {DBHelper.FIELD_NAME,DBHelper.FIELD_AGE};
        Cursor c=database.selectRecode(DBHelper.TABLE_NAME,columns,null,null,null,null,null);
        if (c!=null&& c.getCount()>0){
            while (c.moveToNext()){
                User user=new User();
                String name = c.getColumnName(0);
                String  age = c.getString(1);
                user.setName(name);
                user.setAge(age);
                list.add(user);
            }
        }
        return list;

    }


}
