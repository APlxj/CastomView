package com.castomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class TestView extends View {

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;
    private Paint nPaint;
    private static int StrokeWidth = 30;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setTextSize(80);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(StrokeWidth);

        nPaint = new Paint();
        nPaint.setColor(Color.parseColor("#000000"));
        nPaint.setTextSize(80);
        nPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        nPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private int width;
    private int height;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        canvas.drawColor(Color.parseColor("#D0F5D566"));

        mPaint.setColor(Color.parseColor("#D886F9"));
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, height / 2, width / 2 - StrokeWidth, mPaint);

        mPaint.setColor(Color.parseColor("#F8f6F9"));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(width / 2, height / 2, width / 2 - 2 * StrokeWidth, mPaint);

        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        float[] pts = {width / 4, height / 4
                , width / 4 * 3, height / 4
                , width / 4 * 3, height / 4 * 3
                , width / 4, height / 4 * 3};
        canvas.drawPoints(pts, 0, 8, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(new RectF(width / 4, height / 2, width / 4 * 3, height / 4 * 3), mPaint);
        }

        canvas.drawLine(width * 3 / 8, height * 5 / 8, width * 5 / 8, height * 5 / 8, mPaint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            nPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(0, 0, width / 4 * 3, height / 4 * 3, 0, 0, false, nPaint);
        }
    }
}
