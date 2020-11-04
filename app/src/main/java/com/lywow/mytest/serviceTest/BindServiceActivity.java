package com.lywow.mytest.serviceTest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.annotation.Nullable;

import com.lywow.mytest.R;

public class BindServiceActivity extends Activity {

    private BindTestService.TestServiceBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (BindTestService.TestServiceBinder) service;
            myBinder.startDownload();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service);

//        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startService(new Intent(BindServiceActivity.this, BindTestService.class));
//            }
//        });
//
//        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopService(new Intent(BindServiceActivity.this, BindTestService.class));
//            }
//        });
    }


}
