package com.lywow.mytest.dispatchTouchEvent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lywow.mytest.R;

public class DispatchTouchEventViewGroup extends RelativeLayout {
    private final static String TAG = "";
    public String name = "DispatchTouchEventViewGroup";

    public DispatchTouchEventViewGroup(Context context) {
        super(context);
    }

    public DispatchTouchEventViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchTouchEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DispatchTouchEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(name, "dispatchTouchEvent()");
        boolean result = super.dispatchTouchEvent(event);
        Log.i(name, "dispatchTouchEvent()---" + result);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.e(name, "onInterceptTouchEvent()");
        boolean result = super.onInterceptTouchEvent(event);
        Log.i(name, "onInterceptTouchEvent()---" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(name, "onTouchEvent()");
        boolean result = super.onTouchEvent(event);
        Log.i(name, "onTouchEvent()---" + result);
        return result;
    }
}
