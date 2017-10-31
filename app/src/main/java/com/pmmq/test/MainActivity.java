package com.pmmq.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pmmq.calendar.BaseViewHolder;
import com.pmmq.calendar.CalendarView;
import com.pmmq.calendar.CalendarView.ViewHolderInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewHolderInterface, View.OnClickListener {

    private CalendarView mCalendarView;
    private EditText mPosEd;
    private Button mOKBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendarView = (CalendarView) findViewById(R.id.calendar_view);
        mCalendarView.setViewHolderInterface(this);
        List datas = new ArrayList();
        for (int i = 0; i < 200; i++) {
            datas.add(i);
        }
        mCalendarView.setDatas(datas);


        mPosEd = (EditText) findViewById(R.id.ed_pos);
        mOKBtn = (Button) findViewById(R.id.btn_ok);
        mOKBtn.setOnClickListener(this);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_item, parent, false);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onClick(View v) {
        mCalendarView.scrollToPosition(Integer.valueOf(mPosEd.getText().toString()));
    }

    public class CalendarViewHolder extends BaseViewHolder {

        public TextView txtDayNumber;
        public TextView txtWeekName;
        public TextView txtMonthName;
        public RelativeLayout layoutBackground;
        public View indicatorView;
        public View rightBorderView;

        public CalendarViewHolder(View itemView) {
            super(itemView);
            txtDayNumber = (TextView) itemView.findViewById(R.id.dayNumber);
            txtWeekName = (TextView) itemView.findViewById(R.id.weekName);
            txtMonthName = (TextView) itemView.findViewById(R.id.monthName);
            layoutBackground = (RelativeLayout) itemView.findViewById(R.id.layoutBackground);
            indicatorView = (View) itemView.findViewById(R.id.indicator_view);
            rightBorderView = (View) itemView.findViewById(R.id.right_border_view);
        }

        @Override
        public void onBindViewHolder(Object object, int position) {
            txtDayNumber.setText(String.valueOf(object));
        }

        @Override
        public void onItemClick(View view, int position) {
            mCalendarView.scrollToPosition(position);
        }
    }
}
