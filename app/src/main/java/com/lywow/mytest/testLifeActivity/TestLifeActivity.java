package com.lywow.mytest.testLifeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lywow.mytest.R;

public class TestLifeActivity extends Activity {
    private final static String TAG = "TestLife";
    private static int createTime = 0;
    private int index = 0;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        createTime++;
        index = createTime;
        Log.i(TAG + "-" + index, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_life);


        textView = findViewById(R.id.tv_test_life_activity);
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("测试是否报出异常");
            }
        }).start();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestLifeActivity.this, TestLifeActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        Log.i(TAG + "-" + index, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG + "-" + index, "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG + "-" + index, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG + "-" + index, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG + "-" + index, "onDestroy()");
        super.onDestroy();
    }
}
