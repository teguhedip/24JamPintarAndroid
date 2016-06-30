package com.teguhediprasetyo.www.a24jampintarandroid;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class PickerActivity extends AppCompatActivity {

    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
    TextView dateAndTimeLabel;
    Calendar dateAndTime = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, month);
            dateAndTime.set(Calendar.DAY_OF_MONTH, day);
            updateLabe();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        Button dayBtn = (Button) findViewById(R.id.day_btn);
        dayBtn.setOnClickListener(this);
        Button timeBtn = (Button) findViewById(R.id.time_btn);
        timeBtn.setOnClickListener(this);
        dateAndTimeLabel = (TextView) findViewById(R.id.date_and_time);
        updateLabe();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.day_btn:
                settingTanggal();
                break;
            case R.id.time_btn:
                setJam();
                break;
        }

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void settingTanggal() {
        new DatePickerDialog(PickerActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void setJam() {
        new TimePickerDialog(PickerActivity.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true).show();
    }

    private void updateLabe() {
        dateAndTimeLabel.setText(fmtDateAndTime.format(dateAndTime.getTime()));

    }


}
