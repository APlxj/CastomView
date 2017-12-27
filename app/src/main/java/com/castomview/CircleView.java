package com.castomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class CircleView extends View {

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;

    String[] names = {};

    int[] pro = {0, 20, 40, 90, 160
            , 240, 260, 300, 360};

    String[] colors = {"#000000", "#D690A6", "#367FFF", "#00FF99", "#EEA030"
            , "#89AA15", "#8975F3", "#DADADA", "#9D3A0F", "#129863"
            , "#D690A6", "#367FFF", "#00FF99", "#EEA030"};

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.parseColor("#000000"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < pro.length - 1; i++) {
            mPaint.setColor(Color.parseColor(colors[i]));
            int start = pro[i];
            int end = pro[i + 1];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                canvas.drawArc(0, 0, getWidth(), getHeight(), start + 1, end - start - 1, true, mPaint);
            }
        }

        mPaint.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawCircle(getHeight() / 2, getHeight() / 2, getHeight() / 3, mPaint);

        mPaint.setColor(Color.parseColor("#333333"));
        mPaint.setTextSize(100);
        mPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fm = mPaint.getFontMetrics();

//        mPaint.setColor(Color.parseColor("#0000FF"));
//        canvas.drawLine(0, getHeight() / 2 + fm.top, getWidth(), getHeight() / 2 + fm.top, mPaint);
//
//        mPaint.setColor(Color.parseColor("#FF0000"));
//        canvas.drawLine(0, getHeight() / 2 + fm.ascent, getWidth(), getHeight() / 2 + fm.ascent, mPaint);
//
//        mPaint.setColor(Color.parseColor("#00FF00"));
//        canvas.drawLine(0, getHeight() / 2 + fm.descent, getWidth(), getHeight() / 2 + fm.descent, mPaint);
//
//        mPaint.setColor(Color.parseColor("#000000"));
//        canvas.drawLine(0, getHeight() / 2 + fm.bottom, getWidth(), getHeight() / 2 + fm.bottom, mPaint);

        float Y = getHeight() / 2 + Math.abs((fm.descent + fm.ascent) / 2);
        canvas.drawText("增长率", getWidth() / 2, Y, mPaint);
    }
}
