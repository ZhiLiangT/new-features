package omeng.bbwhm.com.weixin.img_effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import omeng.bbwhm.com.weixin.R;

public class ImgEffectActivity extends AppCompatActivity {
    private ImageView iv1,iv2,iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_effect);
        iv1= (ImageView) findViewById(R.id.img_1);
        iv2= (ImageView) findViewById(R.id.img_2);
        iv3= (ImageView) findViewById(R.id.img_3);

    }
    public static Bitmap initBitmap(Bitmap bitmap, float redValue, float greenValue, float blueValue) {
        Bitmap copyBitmap;
        if (bitmap == null) {
            return null;
        }
        copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                bitmap.getConfig());
        Canvas canvas = new Canvas(copyBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float[] colorArray = new float[] { redValue, 0, 0, 0, 0, 0, greenValue,
                0, 0, 0, 0, 0, blueValue, 0, 0, 0, 0, 0, 1, 0 };
        ColorMatrix colorMatrix = new ColorMatrix(colorArray);// 将保存的颜色矩阵的数组作为参数传入
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(
                colorMatrix);// 再把该colorMatrix作为参数传入来实例化ColorMatrixColorFilter
        paint.setColorFilter(colorFilter);// 并把该过滤器设置给画笔
        canvas.drawBitmap(bitmap, new Matrix(), paint);// 传如baseBitmap表示按照原图样式开始绘制，将得到是复制后的图片
        return copyBitmap;
    }
}
