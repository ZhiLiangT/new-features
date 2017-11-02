package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import omeng.bbwhm.com.weixin.R;

/**
 * Created by tianzl on 2017/11/1.
 */

public class DrawPathTestView extends View {

    private Paint paint;
    private Path path; // 初始化 Path 对象
    public DrawPathTestView(Context context) {
        this(context,null);
    }

    public DrawPathTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawPathTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
        path = new Path(); // 初始化 Path 对象
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 225, false);
//        path.lineTo(400, 542);
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(150, 150);
        path.close();
        canvas.drawPath(path,paint);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,0,200,paint);
    }
}
