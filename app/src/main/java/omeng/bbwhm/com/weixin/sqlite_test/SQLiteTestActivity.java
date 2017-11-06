package omeng.bbwhm.com.weixin.sqlite_test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.retrofit2.bean.User;


public class SQLiteTestActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etAge,etSQL,etId;
    private Button btAdd,btDel,btUpd,btSel,btCreate,btZhiXing,btAll;
    private TextView tvContent;
    private String name,age,id;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_test);
        initView();

    }

    private void initView() {
        tvContent= (TextView) findViewById(R.id.db_tv);
        etName= (EditText) findViewById(R.id.db_et_name);
        etAge= (EditText) findViewById(R.id.db_et_age);
        etSQL= (EditText) findViewById(R.id.db_et_sql);
        etId= (EditText) findViewById(R.id.db_et_id);
        btAdd= (Button) findViewById(R.id.db_bt_add);
        btDel= (Button) findViewById(R.id.db_bt_del);
        btUpd= (Button) findViewById(R.id.db_bt_upd);
        btSel= (Button) findViewById(R.id.db_bt_sel);
        btCreate= (Button) findViewById(R.id.db_bt_create);
        btZhiXing= (Button) findViewById(R.id.db_bt_zhixing);
        btAll= (Button) findViewById(R.id.db_bt_selAll);
        btAdd.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btUpd.setOnClickListener(this);
        btSel.setOnClickListener(this);
        btCreate.setOnClickListener(this);
        btZhiXing.setOnClickListener(this);
        btAll.setOnClickListener(this);
        dbHelper=new DBHelper(this,"test.db",null,1);
        dbHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.db_bt_add:
                add();
                break;
            case R.id.db_bt_del:
                del();
                break;
            case R.id.db_bt_upd:
                update();
                break;
            case R.id.db_bt_sel:
                break;
            case R.id.db_bt_create:
                dbHelper=new DBHelper(this,"test.db",null,1);
                dbHelper.getWritableDatabase();
                break;
            case R.id.db_bt_zhixing:
                break;
            case R.id.db_bt_selAll:
                selAll();
                break;

        }
    }

    private void add() {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        name=etName.getText().toString();
        age=etAge.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.FIELD_NAME, name);
        cv.put(DBHelper.FIELD_AGE,age);
        db.insert(DBHelper.TABLE_NAME,null,cv);
    }
    private void del(){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        id=etId.getText().toString();
        db.delete(DBHelper.TABLE_NAME,"id=?",new String[]{""+id});
    }
    private void update(){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        id=etId.getText().toString();
        name=etName.getText().toString();
        age=etAge.getText().toString();
        ContentValues values=new ContentValues();
        values.put(DBHelper.FIELD_NAME,name);
        values.put(DBHelper.FIELD_AGE,age);
        db.update(DBHelper.TABLE_NAME,values,"id=?",new String[]{""+id});
    }
    private void selAll(){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        List<User> list=new ArrayList<>();
        String[] columns = {DBHelper.FIELD_NAME,DBHelper.FIELD_AGE};
        Cursor c=db.query(DBHelper.TABLE_NAME,columns,null,null,null,null,null);
        if (c!=null&& c.getCount()>0){
            while (c.moveToNext()){
                User user=new User();
                String name = c.getString(0);
                String  age = c.getString(1);
                user.setName(name);
                user.setAge(age);
                list.add(user);
            }
        }
        tvContent.setText(list.toString());
    }

}
