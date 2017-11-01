package omeng.bbwhm.com.weixin.custom_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import omeng.bbwhm.com.weixin.R;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        bt1= (Button) findViewById(R.id.cus_1);
        bt2= (Button) findViewById(R.id.cus_2);
        bt3= (Button) findViewById(R.id.cus_3);
        bt4= (Button) findViewById(R.id.cus_4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cus_1:
                break;
            case R.id.cus_2:
                break;
            case R.id.cus_3:
                break;
            case R.id.cus_4:
                break;
        }
    }
}
