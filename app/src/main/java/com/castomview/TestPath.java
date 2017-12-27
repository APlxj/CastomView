package com.castomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class TestPath extends View {

    public TestPath(Context context) {
        this(context, null);
    }

    public TestPath(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Paint mPaint;
    Path mPath;
    int width;
    int height;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#48D399"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();

        mPath = new Path();
        canvas.drawCircle(width / 2, width / 2, width / 2 - 10, mPaint);

//        canvas.drawPath(mPath, mPaint);
//        canvas.drawColor(Color.parseColor("#CCCCCC"));


        mPaint.setColor(Color.parseColor("#00FFFF"));
        mPath.moveTo(0, height / 3);
        mPath.lineTo(width / 3, height * 2 / 3);
        mPath.lineTo(width, 0);
        canvas.drawPath(mPath, mPaint);
    }
}
