package com.xlg.swipedemo;

import android.os.Bundle;

import com.xlg.swipe.SwipeBackActivity;

/**
 * @Author: jason_hzb
 * @Time: 2018/6/20 上午10:41
 * @Company：小灵狗出行
 * @Description:
 */
public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        setTitleBar("测试");
    }
}
