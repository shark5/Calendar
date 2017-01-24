package com.pmmq.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pmmq.calendar.BaseViewHolder;
import com.pmmq.calendar.CalendarView;
import com.pmmq.calendar.CalendarView.ViewHolderInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewHolderInterface {

    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        mCalendarView.setViewHolderInterface(this);
        List datas = new ArrayList();
        for (int i = 0; i < 20; i++) {
            datas.add(i);
        }
        mCalendarView.setDatas(datas);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_item, parent, false);
        return new CalendarViewHolder(view);
    }

    public class CalendarViewHolder extends BaseViewHolder {

        TextView mTextView;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }

        @Override
        public void onBindViewHolder(Object object, int position) {
            mTextView.setText(String.valueOf(object));
        }

        @Override
        public void onItemClick(View view, int position) {

        }
    }
}
