package omeng.bbwhm.com.weixin.custom_view.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import omeng.bbwhm.com.weixin.R;
import omeng.bbwhm.com.weixin.custom_view.bean.LauguateInfo;

/**
 * Created by tianzl on 2017/11/1.
 */

public class HistogramView extends View {

    private List<LauguateInfo> mData;
    private Paint paintHis;
    private Paint paintTitle;

    private int hisColor=0xFF2EAF79;    //柱状图颜色
    private int lineColor=0xFFCCCCCC;   //坐标线颜色
    private int titleColor=0xFFCCCCCC;  //柱状体底部title字体颜色
    private String nameX="Y轴";         //X轴方向名称
    private String nameY="X轴";         //Y轴方向名称
    private int hisMax=100;             //柱状图最大高度
    private float titleSize=10;         //柱状体底部title字体大小


    public HistogramView(Context context) {
        this(context,null);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        DisplayMetrics metrics=getResources().getDisplayMetrics();
        titleSize= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,titleSize,metrics);
        //获取自定义View属性
        TypedArray typedArray=context.getTheme().
                obtainStyledAttributes(attrs, R.styleable.Histogram_View,defStyleAttr,0);
        hisColor=typedArray.getColor(R.styleable.Histogram_View_histogramColor,hisColor);
        nameX=typedArray.getString(R.styleable.Histogram_View_histogtamNameX);
        nameY=typedArray.getString(R.styleable.Histogram_View_histogtamNameY);
        hisMax=typedArray.getInt(R.styleable.Histogram_View_histogramMax,hisMax);
        titleSize=typedArray.getDimension(R.styleable.Histogram_View_histogtamTitleSize,titleSize);
        titleColor=typedArray.getColor(R.styleable.Histogram_View_histogtamTitleColor,titleColor);
        lineColor=typedArray.getColor(R.styleable.Histogram_View_histogtamLineColor,lineColor);

        paintHis=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintHis.setColor(lineColor);
        paintHis.setTextSize(20);

        paintTitle=new Paint(Paint.ANTI_ALIAS_FLAG);
        paintTitle.setColor(hisColor);
        paintTitle.setTextSize(20);

        jiaData();
    }
    public void jiaData(){
        mData=new ArrayList<>();
        mData.add(new LauguateInfo(50,"Py"));
        mData.add(new LauguateInfo(80,"java"));
        mData.add(new LauguateInfo(20,"R"));
        mData.add(new LauguateInfo(40,"Vue"));
        mData.add(new LauguateInfo(70,"C"));
        mData.add(new LauguateInfo(10,"C++"));
        mData.add(new LauguateInfo(90,"PHP"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,0,300,paintHis);
        int lineWid=85*mData.size()+50;
        canvas.drawLine(0,300,lineWid,300,paintHis);
        paintHis.setColor(titleColor);
        paintHis.setTextAlign(Paint.Align.CENTER);
        for (int i=0;i<mData.size();i++){
            canvas.drawText(mData.get(i).getName(),85*i+55,320,paintHis);
            int hei=mData.get(i).getNumber()*2;
            canvas.drawRect(85*i+25,300-hei,85*(i+1),300,paintTitle);
        }

    }
}
