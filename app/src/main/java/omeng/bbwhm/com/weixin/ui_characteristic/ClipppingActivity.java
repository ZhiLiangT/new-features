package omeng.bbwhm.com.weixin.ui_characteristic;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import omeng.bbwhm.com.weixin.BaseActivity;
import omeng.bbwhm.com.weixin.R;

public class ClipppingActivity extends BaseActivity {
    private ImageView iv7,iv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTAG("ClipppingActivity");
        setContentView(R.layout.activity_clippping);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        iv7= (ImageView) findViewById(R.id.clipp_7);
        iv8= (ImageView) findViewById(R.id.clipp_8);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
            }
        };
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2);
            }
        };
        iv7.setOutlineProvider(viewOutlineProvider);
        iv8.setOutlineProvider(viewOutlineProvider1);

    }

}
