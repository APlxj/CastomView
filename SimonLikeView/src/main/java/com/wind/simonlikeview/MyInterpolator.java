package com.wind.simonlikeview;

import android.animation.TimeInterpolator;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MyInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        return (float) Math.cos((input + 1) * Math.PI) / 2f + 0.5f;
    }
}
