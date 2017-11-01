package omeng.bbwhm.com.weixin.event_distribute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import omeng.bbwhm.com.weixin.R;

public class EventDistributeActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_distribute);
        button= (Button) findViewById(R.id.event_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDistributeActivity.this,"",Toast.LENGTH_SHORT).show();
                Log.i("EventDistributeActivity","onClick()");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("EventDistributeActivity","onTouch()  "+event.getAction());
                return false;
            }
        });
    }
}
