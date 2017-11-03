package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import omeng.bbwhm.com.weixin.R;

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
        paint.setColor(Color.YELLOW);
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制一个圆
//        canvas.drawCircle(300,300,200,paint);
//        paint.setStrokeWidth(50);
//        paint.setStrokeCap(Paint.Cap.SQUARE);
//        float[] attr={0,0,180,50,240,50,300,50,360,50,420,50};
////        canvas.drawPoint(180,50,paint);
//        //绘制点
//        canvas.drawPoints(attr,2,8,paint);
//        paint.setStrokeWidth(2);
        //绘制矩形
//        canvas.drawRect(10,0,100,100,paint);
//        //绘制文字
//        canvas.drawText("我和圆是一个View",0,200,paint);
//        //画椭圆
//        canvas.drawOval(10,220,180,300,paint);
//        //画直线
//        canvas.drawLine(10,300,100,400,paint);
//        //绘制圆角矩形
//        canvas.drawRoundRect(10,410,180,500,20,20,paint);
//        //绘制扇形或弧形 前四个参数表示弧形所在的椭圆的坐标,第五的参数表示弧形的起始角度，
//        //（x轴的正向，即正右的方向，是0度的位置，顺时针为正角度，逆时针为负角度）
//        //第六个参数，表示弧形划过的角度，第七个参数表示是否连接到圆心，
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawArc(10,510,180,600,-100,100,true,paint);
//        canvas.drawArc(10,610,180,700,-100,100,false,paint);
//        canvas.drawColor(Color.RED);
//        Shader shader=new LinearGradient(100,100,500,500,
//                Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300,300,200,paint);
//        Shader shader1=new RadialGradient(300,300,200,Color.parseColor("#E91E63")
//                ,Color.parseColor("#2196F3"),Shader.TileMode.MIRROR);
//        paint.setShader(shader1);
//        canvas.drawCircle(300,300,200,paint);
        //扫描渐变
//        Shader shader2=new SweepGradient(300,300,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"));
//        paint.setShader(shader2);
//        canvas.drawCircle(300,300,200,paint);
        //Bitmap着色
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.b1);
//        Shader shader3=new BitmapShader(bitmap,Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
//        paint.setShader(shader3);
//        canvas.drawCircle(300,300,200,paint);
        //ComposeShader 混合着色器
//        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.mipmap.link);
//        Shader shader1=new BitmapShader(bitmap1,Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
//
//        Bitmap bitmap2=BitmapFactory.decodeResource(getResources(),R.mipmap.music);
//        Shader shader2=new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//
//        Shader shaderCom=new ComposeShader(shader1,shader2, PorterDuff.Mode.SRC_OVER);
//        paint.setShader(shaderCom);
//        canvas.drawCircle(300,300,200,paint);
        //ColorFilter
//        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.mipmap.link);
//        ColorFilter colorFilter=new LightingColorFilter(0Xffffff,0x003000);
//        paint.setColorFilter(colorFilter);
//        canvas.drawBitmap(bitmap1,0,200,paint);
//        1.3 setXfermode(Xfermode xfermode)
//        @SuppressLint("DrawAllocation")
//        Xfermode xfermode=new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
//        @SuppressLint("DrawAllocation") Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.mipmap.link);
//        @SuppressLint("DrawAllocation") Bitmap bitmap2=BitmapFactory.decodeResource(getResources(),R.mipmap.b1);
//        canvas.drawBitmap(bitmap1,0,0,paint);
//        paint.setXfermode(xfermode);
//        canvas.drawBitmap(bitmap2,50,50,paint);
//        paint.setXfermode(null);
//        paint.setStyle(Paint.Style.STROKE); // FILL 模式，填充
//        paint.setStrokeWidth(1);
//        canvas.drawCircle(150, 125, 100, paint);
//        paint.setStrokeWidth(5);
//        canvas.drawCircle(400, 125, 100, paint);
//        paint.setStrokeWidth(40);
//        canvas.drawCircle(650, 125, 100, paint);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.mipmap.link);
//        canvas.drawBitmap(bitmap1,100,100,paint);
//        paint.setShadowLayer(10, 0, 0, Color.RED);
//        canvas.drawText("Hello TZL", 80, 300, paint);
       // paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        paint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
        canvas.drawBitmap(bitmap1,100,100,paint);
        
    }
}
