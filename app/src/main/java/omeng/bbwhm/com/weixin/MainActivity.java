package omeng.bbwhm.com.weixin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import omeng.bbwhm.com.weixin.custom_view.CustomActivity;
import omeng.bbwhm.com.weixin.event_distribute.EventDistributeActivity;
import omeng.bbwhm.com.weixin.ui_characteristic.ClipppingActivity;
import omeng.bbwhm.com.weixin.ui_characteristic.RippleActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button bt1,bt2,bt3,bt4,bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTAG("MainActivity");
        setContentView(R.layout.activity_main);
        bt1= (Button) findViewById(R.id.bt1);
        bt2= (Button) findViewById(R.id.bt2);
        bt3= (Button) findViewById(R.id.bt3);
        bt4= (Button) findViewById(R.id.bt4);
        bt5= (Button) findViewById(R.id.bt5);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                Intent intentClipp=new Intent(this,ClipppingActivity.class);
                startActivity(intentClipp);
                break;
            case R.id.bt2:
                Intent intentRipple=new Intent(this,RippleActivity.class);
                startActivity(intentRipple);
                break;
            case R.id.bt3:
                Intent intentEvent=new Intent(this, EventDistributeActivity.class);
                startActivity(intentEvent);
                break;
            case R.id.bt4:
                Intent intentCustom=new Intent(this, CustomActivity.class);
                startActivity(intentCustom);
                break;
        }
    }

}
