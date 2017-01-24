package com.pmmq.calendar;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by panj on 2017/1/24.
 */

public class CalendarView extends RelativeLayout {
    private RecyclerView mRecyclerView;
    private ViewHolderInterface mViewHolderInterface;
    private CalendarAdapter mAdapter;

    public CalendarView(Context context) {
        super(context);
        init(context);
    }

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mRecyclerView = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new CalendarAdapter();
        setAdapter(mAdapter);
        this.addView(mRecyclerView);
    }

    private void setLayoutManager(RecyclerView.LayoutManager layout) {
        if (layout != null && mRecyclerView != null) {
            mRecyclerView.setLayoutManager(layout);
        }
    }

    public void addItemDecoration(RecyclerView.ItemDecoration decoration) {
        if (decoration != null && mRecyclerView != null) {
            mRecyclerView.addItemDecoration(decoration);
        }
    }

    private void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter != null && mRecyclerView != null) {
            mRecyclerView.setAdapter(adapter);
        }
    }

    public void setDatas(List<Object> list) {
        if (mAdapter != null && list != null) {
            mAdapter.setDatas(list);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setViewHolderInterface(ViewHolderInterface viewHolderInterface) {
        mViewHolderInterface = viewHolderInterface;
    }

    class CalendarAdapter extends RecyclerView.Adapter<BaseViewHolder> {

        private List<Object> mList;

        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mViewHolderInterface != null) {
                return mViewHolderInterface.getViewHolder(parent, viewType);
            }
            return null;
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            if (holder != null) {
                holder.onBindViewHolder(mList.get(position), position);
            }
        }

        @Override
        public int getItemCount() {
            return mList != null ? mList.size() : 0;
        }

        public void setDatas(List<Object> list) {
            mList = list;
        }
    }

    public interface ViewHolderInterface {
        BaseViewHolder getViewHolder(ViewGroup parent, int viewType);
    }
}
