package com.lywow.mytest.recyclerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lywow.mytest.R;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleAdapterHolder> {
    private Context mContext;
    private List<Commodity> mCommodityList;
    private View inflater;

    public RecycleAdapter(Context context, List<Commodity> list) {
        this.mContext = context;
        this.mCommodityList = list;
    }

    @NonNull
    @Override
    public RecycleAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext).inflate(R.layout.item_commodity, parent, false);
        return new RecycleAdapterHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterHolder holder, int position) {//填入数据
        Commodity commodity = mCommodityList.get(position);
        holder.tvPriceCard.setText(commodity.getPrice() + "元");
        holder.ivBubble.setImageLevel(commodity.getHotLevel());
    }

    @Override
    public int getItemCount() {
        return mCommodityList == null ? 0 : mCommodityList.size();
    }

    static class RecycleAdapterHolder extends RecyclerView.ViewHolder {
        TextOutlineView tvPriceCard;
        ImageView ivBubble;

        public RecycleAdapterHolder(View itemView) {
            super(itemView);
            tvPriceCard = itemView.findViewById(R.id.tv_shopping_mall_price_card);
            ivBubble = itemView.findViewById(R.id.iv_bubble_for_commodity);
        }
    }
}
