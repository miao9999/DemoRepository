package com.kotlin.limiao.clearedittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import java.util.concurrent.Future;

/**
 * Created by miao on 2018/12/6.
 */
public class ClearEdtittext extends EditText {


    public ClearEdtittext(Context context) {
        super(context);
    }

    public ClearEdtittext(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClearEdtittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP){
            if (getCompoundDrawables()[2] != null){
                boolean touchable  = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < (getWidth() - getPaddingRight()));
                if (touchable){
                    this.setText("");
                }

            }
        }
        return super.onTouchEvent(event);
    }
}
