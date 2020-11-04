package com.lywow.mytest.dispatchTouchEvent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.lywow.mytest.R;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class DispatchTouchEventActivity extends Activity {

    private DispatchTouchEventViewGroup layoutLv1;
    private DispatchTouchEventViewGroup layoutLv2;
    private DispatchTouchEventView button;
    private DispatchTouchEventView button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_touch_event);
        initView();
        initClickEvent();
    }

    public void initView() {
        layoutLv1 = findViewById(R.id.rl_lv1_dispatch_touch_event);
        layoutLv2 = findViewById(R.id.rl_lv2_dispatch_touch_event);
        button = findViewById(R.id.btn_dispatch_touch_event);
        button2 = findViewById(R.id.btn_dispatch_touch_event_2);
        layoutLv1.name = "rl_lv1";
        layoutLv2.name = "rl_lv2";
        button.name = "button";
        button2.name = "button2";
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initClickEvent() {
        layoutLv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(layoutLv1.name, "消费点击事件");
            }
        });
        layoutLv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(layoutLv2.name, "消费点击事件");
            }
        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(button.name, "消费点击事件");
//            }
//        });
//        button.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                return false;
//            }
//        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bool = true;
                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:
                        Log.i(button.name, "消费按下事件----------");
                        break;
                    case ACTION_UP:
                        Log.i(button.name, "消费松开事件----------");
                        break;
                    default:
                        Log.i(button.name, "其他事件--------------");
                        bool = false;
                        break;
                }
                return bool;
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bool = true;
                switch (motionEvent.getAction()) {
                    case ACTION_DOWN:
                        Log.i(button2.name, "消费按下事件----------");
                        break;
                    case ACTION_UP:
                        Log.i(button2.name, "消费松开事件----------");
                        break;
                    default:
                        Log.i(button2.name, "其他事件--------------");
                        bool = false;
                        break;
                }
                return bool;
            }
        });
    }


}
