package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import omeng.bbwhm.com.weixin.R;

/**
 * Created by tianzl on 2017/11/3.
 */

public class DrawCanvasView extends View {
    Paint paint;
    public DrawCanvasView(Context context) {
        this(context,null);
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        //裁剪
        canvas.save();
        canvas.clipRect(20,20,40,40);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
        //平移
        canvas.save();
        canvas.translate(200,0);
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.restore();
        //旋转
        canvas.save();
        canvas.rotate(45,45,45);
        canvas.drawBitmap(bitmap,50,50,paint);
        canvas.restore();
        //放缩
        canvas.save();
        canvas.scale(1.3f, 1.3f, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap,90,90,paint);
        canvas.restore();
        //错切
        canvas.save();
        canvas.skew(0,0.5f);
        canvas.drawBitmap(bitmap,150,150,paint);
        canvas.restore();
        //使用Matrix来做变换
        Matrix matrix=new Matrix();
        matrix.reset();
        matrix.postTranslate(200,200);

        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,50,200,paint);
        canvas.restore();

        matrix.postRotate(45,45,250);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,50,250,paint);
        canvas.restore();
        //使用camera进行三维变化

        Camera camera=new Camera();
        camera.save();
        canvas.save();
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.drawBitmap(bitmap,50,300,paint);
        camera.restore();



    }
}
