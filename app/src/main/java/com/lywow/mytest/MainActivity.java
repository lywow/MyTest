package com.lywow.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.lywow.mytest.dispatchTouchEvent.DispatchTouchEventActivity;
import com.lywow.mytest.testLifeActivity.TestLifeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvForDispatchTouchEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        findViewById(R.id.tv_dispatch_touch_event).setOnClickListener(this);
        findViewById(R.id.tv_test_life_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.i("MainActivity", "----------------");
        switch (view.getId()) {
            case R.id.tv_dispatch_touch_event:
                startActivity(new Intent(this, DispatchTouchEventActivity.class));
                break;
            case R.id.tv_test_life_activity:
                startActivity(new Intent(this, TestLifeActivity.class));
                break;
            default:
                break;
        }
    }
}