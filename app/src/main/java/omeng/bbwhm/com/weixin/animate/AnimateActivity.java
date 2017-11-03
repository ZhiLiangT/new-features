package omeng.bbwhm.com.weixin.animate;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.animate.view.SportsLinearView;
import omeng.bbwhm.com.weixin.animate.view.SportsView;

public class AnimateActivity extends AppCompatActivity {
    //Sample08ObjectAnimatorView animatorView;
    SportsView sportsView;
    SportsLinearView sportsLinearView;
    View textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        initView();
        initData();


    }
    private void initView() {
        sportsView= (SportsView) findViewById(R.id.anim_samp_2);
        sportsLinearView= (SportsLinearView) findViewById(R.id.anim_samp_3);
        textView= (View) findViewById(R.id.textView);
    }

    private void initData() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 100f);
        anim.setDuration(3000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                //animatorView.setProgress(currentValue);
                sportsView.setProgress(currentValue);
                sportsLinearView.setProgress(currentValue);

            }
        });
        anim.start();

        ValueAnimator animator = ValueAnimator.ofArgb( 0xffE91E63, 0xff2196F3);
        animator.setDuration(10000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setBackgroundColor((Integer) animation.getAnimatedValue());
            }
        });
        animator.start();
    }


}
