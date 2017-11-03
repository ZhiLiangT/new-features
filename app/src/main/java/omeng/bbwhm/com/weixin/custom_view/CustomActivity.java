package omeng.bbwhm.com.weixin.custom_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.custom_view.ac.CanvasDrawActivity;
import omeng.bbwhm.com.weixin.custom_view.ac.GroupViewActivity;
import omeng.bbwhm.com.weixin.custom_view.ac.HistogramActivity;
import omeng.bbwhm.com.weixin.custom_view.ac.LoweActivity;
import omeng.bbwhm.com.weixin.custom_view.ac.TextDrawActivity;

public class CustomActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        bt1= (Button) findViewById(R.id.cus_1);
        bt2= (Button) findViewById(R.id.cus_2);
        bt3= (Button) findViewById(R.id.cus_3);
        bt4= (Button) findViewById(R.id.cus_4);
        bt5= (Button) findViewById(R.id.cus_5);
        bt6= (Button) findViewById(R.id.cus_6);
        bt7= (Button) findViewById(R.id.cus_7);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cus_1:
                break;
            case R.id.cus_2:
                Intent intentLowe=new Intent(this, LoweActivity.class);
                startActivity(intentLowe);
                break;
            case R.id.cus_3:
                Intent intentHis=new Intent(this, HistogramActivity.class);
                startActivity(intentHis);
                break;
            case R.id.cus_4:
                break;
            case R.id.cus_5:
                Intent intentText=new Intent(this, TextDrawActivity.class);
                startActivity(intentText);
                break;
            case R.id.cus_6:
                Intent intentCan=new Intent(this, CanvasDrawActivity.class);
                startActivity(intentCan);
                break;
            case R.id.cus_7:
                Intent intentGroup=new Intent(this, GroupViewActivity.class);
                startActivity(intentGroup);
                break;
        }
    }
}
