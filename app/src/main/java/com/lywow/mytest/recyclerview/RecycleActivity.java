package com.lywow.mytest.recyclerview;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lywow.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<Commodity> mData;
    private RecycleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getResources().getDrawable(R.drawable.img_shopping_mall_goods_shelf));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter = new RecycleAdapter(this, mData));

    }

    protected void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Commodity commodity = new Commodity();
            commodity.setHotLevel(i % 4);
            commodity.setPrice((i % 4 + 1) * 356);
            mData.add(commodity);
        }
    }

}
