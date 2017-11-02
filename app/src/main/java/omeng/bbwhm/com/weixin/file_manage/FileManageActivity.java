package omeng.bbwhm.com.weixin.file_manage;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.file_manage.utils.Constant;

public class FileManageActivity extends BaseActivity implements View.OnClickListener{
    private TextView tvTime;
    private ImageView ivUser;
    private ImageView ivWifi;
    private LinearLayout llMusic;
    private LinearLayout llVideo;
    private LinearLayout llUSB;


    @Override
    public void initContentView() {
        setContentView(R.layout.activity_file_manage);
    }

    @Override
    public void initViews() {
        tvTime= findViewById(R.id.main_time);
        ivUser= findViewById(R.id.main_user);
        ivWifi= findViewById(R.id.main_wifi);
        llMusic= findViewById(R.id.main_ll_music);
        llVideo= findViewById(R.id.main_ll_video);
        llUSB= findViewById(R.id.main_ll_usb);
    }
    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        ivUser.setOnClickListener(this);
        ivWifi.setOnClickListener(this);
        llMusic.setOnClickListener(this);
        llVideo.setOnClickListener(this);
        llUSB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intentRes=new Intent(this,ResourceListActivity.class);
        switch (v.getId()) {
            case R.id.main_ll_music:
                intentRes.putExtra(Constant.TAG_URL, Constant.URL_MUSIC);
                intentRes.putExtra(Constant.TAG_TYPE, 0);
                startActivity(intentRes);
                break;
            case R.id.main_ll_video:
                intentRes.putExtra(Constant.TAG_URL, Constant.URL_VIDEO);
                intentRes.putExtra(Constant.TAG_TYPE, 1);
                startActivity(intentRes);
                break;
            case R.id.main_ll_usb:
                intentRes.putExtra(Constant.TAG_URL, Constant.URL_USB);
                intentRes.putExtra(Constant.TAG_TYPE, 2);
                startActivity(intentRes);
                break;
        }
    }
}
