package com.stay4cold.ninesquareviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.stay4cold.ninesquareview.NineSquareView;
import com.stay4cold.ninesquareview.SquareViewInfo;

import java.util.ArrayList;

/**
 * Author:  wangchenghao
 * Email:   wangchenghao123@126.com
 * Date:    16/7/18
 * Description:
 */
public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ArrayList<SquareViewInfo>> infos = new ArrayList<>();

    public void addInfo(ArrayList<SquareViewInfo> info) {
        infos.add(info);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder)holder).nineSquareView.setViewInfos(infos.get(position));
        ((Holder)holder).tv.setText("" + position);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public NineSquareView nineSquareView;
        public TextView tv;
        public Holder(View itemView) {
            super(itemView);
            nineSquareView = (NineSquareView)itemView.findViewById(R.id.nine_view);
            tv = (TextView) itemView.findViewById(R.id.tv);
            nineSquareView.setOnItemClickListener(new NineSquareView.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int index) {
                    Toast.makeText(view.getContext(), "当前点击的index为："+index, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
