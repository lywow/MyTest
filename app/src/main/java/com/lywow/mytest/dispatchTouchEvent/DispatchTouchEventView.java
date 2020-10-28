package com.lywow.mytest.dispatchTouchEvent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DispatchTouchEventView extends androidx.appcompat.widget.AppCompatButton {
    private final static String TAG = "";
    public String name = "DispatchTouchEventView";
    private int count = 0;

    public DispatchTouchEventView(@NonNull Context context) {
        super(context);
    }

    public DispatchTouchEventView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchTouchEventView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(name, "dispatchTouchEvent()");
        boolean result = super.dispatchTouchEvent(event);
        Log.i(name, "dispatchTouchEvent()---" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(name, "onTouchEvent()");
        count++;
        boolean result = super.onTouchEvent(event);
        Log.i(name, "onTouchEvent()---" + result);
        Log.i(name, "onTouchEvent()---" + count);
        return result;
    }
}
