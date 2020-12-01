package com.lywow.mytest.jsonTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.lywow.mytest.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTestActivity extends Activity {
    private TextView textView;
    private String json = "{\"Code\":0,\"Message\":\"成功\",\"Data\":{\"ActivityInfo\":{\"PrizeNameList\":[\"10两银子\",\"40两银子\",\"50两银子\"]},\"UserActivityInfo\":{\"RemainViews\":3}}}";
    private String[] mItemStrings = {"京东200元", "500两", "话费5元", "8888两", "一张", "88888两", "5张", "888两", "话费50元", "10张"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textView = findViewById(R.id.tv_json_test);
        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("data", mItemStrings);
//            jsonObject.put("asd", 555);
            JSONObject jsonObject1 = new JSONObject(json);
            JSONArray jsonArray = jsonObject1.optJSONObject("Data").optJSONObject("ActivityInfo").optJSONArray("PrizeNameList");
            for (int i = 0; i < jsonArray.length(); i++) {
                textView.setText(jsonArray.getString(i) + "\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
