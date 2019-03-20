package com.kotlin.limiao.characterevaluatordemo;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/6.
 */
public class CharacterEvaluatorActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.evaluator_activity);

        tv = (TextView) findViewById(R.id.tv);

        findViewById(R.id.start_anim).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofObject(
                        new CharEvaluator()
                        , new Character('A')
                        , new Character('Z')
                );
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char text = (Character) animation.getAnimatedValue();
                        tv.setTextColor(Color.parseColor("#ff0000"));
                        tv.setText(String.valueOf(text));
                    }
                });
                animator.setDuration(10000);
//                animator.setInterpolator(new AccelerateInterpolator());
                animator.setInterpolator(new MyInterpolator());
                animator.start();
            }
        });
    }


    class CharEvaluator implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {


            int start = startValue;
            int end = endValue;
            int current = (int) (start + fraction *(end - start));
            char result = (char) current;

            Log.e("CharEvaluator", "fraction:" + fraction);

//            Log.e("CharEvaluator", "start:" + start);
//            Log.e("CharEvaluator", "end:" + end);
//            Log.e("CharEvaluator", "current:" + current);
//            Log.e("CharEvaluator", "result:" + result);
//            Log.e("CharEvaluator", "startValue:" + startValue);
//            Log.e("CharEvaluator", "endValue:" + endValue);
            return result;
        }
    }
}
