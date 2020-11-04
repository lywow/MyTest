package com.lywow.mytest.serviceTest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

public class BindTestService extends Service {
    private final static String TAG = "BindTestService";

    private int second = 0, minute = 0;
    private TimeHandler handler;
    private TestServiceBinder mBinder = new TestServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand()");
        handler = new TimeHandler(this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.destroy();
        Log.i(TAG, "onDestroy()");
    }

    class TestServiceBinder extends Binder {

        public void startDownload() {
            Log.d("TAG", "startDownload() executed");
        }

    }

    static class TimeHandler extends Handler {
        private WeakReference<BindTestService> weakReference;
        private static TimeHandler instance;
        private final static int SIGNAL_FOR_TIMER = 10086;

        private TimeHandler(BindTestService bindTestService) {
            weakReference = new WeakReference<>(bindTestService);
        }

        public void init(BindTestService bindTestService) {
            if (instance == null) {
                instance = new TimeHandler(bindTestService);
            }
            start();
        }

        public void destroy() {
            if (instance != null) {
                instance.removeMessages(SIGNAL_FOR_TIMER);
                instance = null;
            }
        }

        private void start() {
            if (instance != null) {
                Message message = Message.obtain();
                message.what = SIGNAL_FOR_TIMER;
                instance.sendMessageDelayed(message, 1000);
            }
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == SIGNAL_FOR_TIMER) {
                if (weakReference.get() != null) {
                    weakReference.get().second++;
                    start();
                }
            }
        }
    }
}
