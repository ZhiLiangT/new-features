package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tianzl on 2017/11/1.
 */

public class TestCusView extends View {
    private Paint paint;
    public TestCusView(Context context) {
        this(context,null);
    }

    public TestCusView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestCusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制一个圆
//        canvas.drawCircle(300,300,200,paint);
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        float[] attr={0,0,180,50,240,50,300,50,360,50,420,50};
//        canvas.drawPoint(180,50,paint);
        //绘制点
        canvas.drawPoints(attr,2,8,paint);
        paint.setStrokeWidth(2);
        //绘制矩形
        canvas.drawRect(10,0,100,100,paint);
        //绘制文字
        canvas.drawText("我和圆是一个View",0,200,paint);
        //画椭圆
        canvas.drawOval(10,220,180,300,paint);
        //画直线
        canvas.drawLine(10,300,100,400,paint);
        //绘制圆角矩形
        canvas.drawRoundRect(10,410,180,500,20,20,paint);
        //绘制扇形或弧形 前四个参数表示弧形所在的椭圆的坐标,第五的参数表示弧形的起始角度，
        //（x轴的正向，即正右的方向，是0度的位置，顺时针为正角度，逆时针为负角度）
        //第六个参数，表示弧形划过的角度，第七个参数表示是否连接到圆心，
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(10,510,180,600,-100,100,true,paint);
        canvas.drawArc(10,610,180,700,-100,100,false,paint);

    }
}
