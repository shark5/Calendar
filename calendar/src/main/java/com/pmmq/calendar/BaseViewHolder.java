package com.pmmq.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by panj on 2017/1/24.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(v, getAdapterPosition());
            }
        });
    }

    public abstract void onBindViewHolder(Object object, int position);

    public abstract void onItemClick(View view, int position);
}
