package com.kotlin.limiao.characterevaluatordemo;

import android.animation.TimeInterpolator;
import android.util.Log;

/**
 * Created by qijian on 16/12/5.
 */
public class MyInterpolator implements TimeInterpolator {

    public float getInterpolation(float input) {

        // 这里的 input 值与 public Character evaluate(float fraction, Character startValue, Character endValue)
        // 中的 fraction 的值是一样的
        Log.e("CharEvaluator", "input:" + input);
        float v = 1 - input;

        Log.e("yy", "v=" + v);

//        return v;
        return input;
    }
}
