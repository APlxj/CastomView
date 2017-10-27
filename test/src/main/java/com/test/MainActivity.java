package com.test;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView iv_t = (ImageView) findViewById(R.id.iv_t);
        final TextView tv_t = (TextView) findViewById(R.id.tv_t);
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator);
        animator.setTarget(iv_t);
        animator.start();
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_t, "rotate", 1f, 0f, 1f, 0f);
//        objectAnimator.setDuration(5000);
//        objectAnimator.start();
//        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        final Animation counterAnimation = AnimationUtils.loadAnimation(this, R.anim.counteralpha);
//        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        final Animation rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
//        iv_t.setAnimation(rotate1);
//        rotate1.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation a) {
//                iv_t.setAnimation(animation);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });

        //使动画结束后保持结束状态
//        animation.setFillEnabled(true);
//        animation.setFillAfter(true);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv_t.setAnimation(counterAnimation);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        counterAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                iv_t.setAnimation(rotate);
//                tv_t.setAnimation(rotate);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
    }
}
