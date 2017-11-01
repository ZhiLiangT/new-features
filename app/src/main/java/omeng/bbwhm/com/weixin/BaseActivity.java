package omeng.bbwhm.com.weixin;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import omeng.bbwhm.com.weixin.utils.L;


/**
 * Created by tianzl on 2017/10/30.
 */

public class BaseActivity extends AppCompatActivity {
    /**生命周期标识*/
    protected  String TAG;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        TAG=this.getClass().getSimpleName();
        L.i("ACS"+TAG,"onCreate");
    }
    public void setTAG(String tag){
        TAG=tag;
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.i("ACS"+TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.i("ACS"+TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.i("ACS"+TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.i("ACS"+TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.i("ACS"+TAG, "onResume: ");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        L.i("ACS"+TAG, "onRestart: ");
    }
}
