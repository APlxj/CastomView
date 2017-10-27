package com.castomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class RainbowBar extends View {

    private Context context;

    public RainbowBar(Context context) {
        super(context);
        this.context = context;
    }

    public RainbowBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RainbowBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    //控件的宽度也可以通过控件对象的getMeasuredWidth()来得到
    int width;
    int height;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * @param changed 该参数指出当前ViewGroup的尺寸或者位置是否发生了改变
     * @param left    top right bottom : 当前ViewGroup相对于其父控件的坐标位置
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF = new RectF(getLeft(), getTop(), getRight(), getBottom());
    }

    RectF rectF;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //控件的宽度和高度：布局文件中设置的宽度和高度
        width = getWidth();
        height = getHeight();

        //半径
        int radius = (width > height ? height : width) / 4;
        //画笔
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#80FF0000"));
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(width / 2, height / 2, radius, paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(width / 2, height / 2, radius * 98 / 100, paint);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
