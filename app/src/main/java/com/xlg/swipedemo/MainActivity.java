package com.xlg.swipedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xlg.swipe.SwipeBackActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitleBar("首页","测试");
        hideBackBtn();
    }

    @Override
    public void onTitleBarRightClick() {
        super.onTitleBarRightClick();

        Intent intent = new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}
