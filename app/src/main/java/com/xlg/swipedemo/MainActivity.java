package com.xlg.swipedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xlg.swipe.SwipeBackActivity;

public class MainActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
