package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

/**
 * Created by tianzl on 2017/11/3.
 */

public class DrawTextView extends View {
    TextPaint textPaint;
    Paint paint;
    Path path;
    String text="Hello 美女直骨";
    String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";

    public DrawTextView(Context context) {
        this(context,null);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        textPaint=new TextPaint(TextPaint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(20);
        textPaint.setStyle(Paint.Style.STROKE);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(40);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //添加删除线
       // paint.setStrikeThruText(true);
        //是否添加下划线
       // paint.setUnderlineText(true);
        //是否倾斜
        //paint.setTextSkewX(-0.5f);
        //设置文字横向缩放
        paint.setTextScaleX(2f);
        //设置文字间距 默认值为0
        paint.setLetterSpacing(0.2f);
        //以CSS的 font-feature-settings 的方式来设置文字
        paint.setFontFeatureSettings("PKRN");
        //设置地域
        paint.setTextLocale(Locale.JAPAN);
        //是否开启次像素级的抗锯齿
        path=new Path();
        path.moveTo(60, 100);
        path.quadTo(100,160,150,200);
        path.quadTo(160,120,100,100);
        path.quadTo(240,200,300,300);
        canvas.drawText(text,20,60,paint);
//        canvas.drawPath(path,paint);
//        canvas.drawTextOnPath("今天天气不过，适合出去玩",path,20,30,paint);
        //支持自动换行  参数三 文字区域的宽度，达到该宽度自动换行
        //align文字的对齐方式  1：行间距 0：行间距的额外增加值，
        //是否在文字上下添加额外的空间，避免某些过高字符的绘制出现越界
        StaticLayout staticLayout1=new StaticLayout(text1, textPaint,600,
                Layout.Alignment.ALIGN_NORMAL,1,0,true);
        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        StaticLayout staticLayout2 = new StaticLayout(text2, textPaint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();

        canvas.translate(50, 100);
        staticLayout1.draw(canvas);
        canvas.translate(0, 200);
        staticLayout2.draw(canvas);
        canvas.restore();




    }
}
