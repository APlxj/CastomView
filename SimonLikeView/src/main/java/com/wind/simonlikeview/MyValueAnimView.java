package com.wind.simonlikeview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MyValueAnimView extends View {

    Point point;
    Paint mPaint;
    private static float radius = 50f;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    public MyValueAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.parseColor("#00FF00"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (null == point) {
            point = new Point.Bulder()
                    .X(radius)
                    .Y(radius)
                    .bulder();
            canvas.drawCircle(point.getX(), point.getY(), radius, mPaint);
            startValueAnima();
        } else {
            canvas.drawCircle(point.getX(), point.getY(), radius, mPaint);
        }
    }

    private void startValueAnima() {
        Point pointEnd = new Point.Bulder()
                .X(radius)
                .Y(getHeight()-radius)
                .bulder();
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), point, pointEnd);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                point = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(5000);
        /*BounceInterpolator:回弹效果
        * AccelerateInterpolator：加速度效果
        * */
        animator.setInterpolator(new MyInterpolator());
        animator.start();

        /*ObjectAnimator animator1 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#FFFFFFFF", "#00000000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.play(animator1).with(animator);
        animatorSet.start();*/
    }
}
