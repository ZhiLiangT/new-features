package omeng.bbwhm.com.weixin.sqlite_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import omeng.bbwhm.com.weixin.R;

public class SQLiteTestActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etAge,etSQL;
    private Button btAdd,btDel,btUpd,btSel,btCreate,btZhiXing;
    private TextView tvContent;

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
        btAdd= (Button) findViewById(R.id.db_bt_add);
        btDel= (Button) findViewById(R.id.db_bt_del);
        btUpd= (Button) findViewById(R.id.db_bt_upd);
        btSel= (Button) findViewById(R.id.db_bt_sel);
        btCreate= (Button) findViewById(R.id.db_bt_create);
        btZhiXing= (Button) findViewById(R.id.db_bt_zhixing);
        btAdd.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btUpd.setOnClickListener(this);
        btSel.setOnClickListener(this);
        btCreate.setOnClickListener(this);
        btZhiXing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.db_bt_add:
                break;
            case R.id.db_bt_del:
                break;
            case R.id.db_bt_upd:
                break;
            case R.id.db_bt_sel:
                break;
            case R.id.db_bt_create:
                break;
            case R.id.db_bt_zhixing:
                break;

        }
    }
}
