package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by tianzl on 2017/11/3.
 */

public class DrawLinearLayout extends LinearLayout {
    Paint paint;

    public DrawLinearLayout(Context context) {
        this(context,null);
    }

    public DrawLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(60);
        paint.setStrokeCap(Paint.Cap.SQUARE);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        //在线面绘制，不会被子类遮盖
        canvas.drawPoint(50,50,paint);
        canvas.drawPoint(200,220,paint);
        canvas.drawPoint(260,260,paint);
        canvas.drawPoint(300,280,paint);

    }
}
