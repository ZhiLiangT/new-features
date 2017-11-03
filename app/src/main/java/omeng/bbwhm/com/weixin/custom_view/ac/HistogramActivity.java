package omeng.bbwhm.com.weixin.custom_view.ac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.custom_view.view.HistogramView;

/**
 * 柱状图
 */
public class HistogramActivity extends AppCompatActivity {
    private HistogramView view;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);
        view= (HistogramView) findViewById(R.id.cus_zhifang);

    }
}
