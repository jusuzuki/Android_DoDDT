package com.epicodus.doddt.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.epicodus.doddt.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TimezoneActivity extends AppCompatActivity {

    private long mCurrentTime;
    private TextView mTimePDX;
    private TextView mTimeSAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezone);

        mTimePDX = (TextView) findViewById(R.id.timePDX);
        mTimeSAO = (TextView) findViewById(R.id.timeSAO);

        mCurrentTime = new Date().getTime();

        mTimePDX.setText(getTimePDX());
        mTimeSAO.setText(getTimeSAO());
    }



    public String getTimePDX(){
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mma");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return formatter.format(mCurrentTime);
    }

    public String getTimeSAO(){
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d 'at' h:mma");
        formatter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        return formatter.format(mCurrentTime);
    }



}
