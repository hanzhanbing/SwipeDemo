package com.xlg.swipedemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.xlg.swipe.SwipeBackActivity;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

/**
 * @Author: jason_hzb
 * @Time: 2018/6/20 上午10:44
 * @Company：小灵狗出行
 * @Description:
 */
public class BaseActivity extends SwipeBackActivity implements BaseListener {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        // 窗口自适应键盘
        getWindow()
                .setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                                | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // 强制设置为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // 设置状态栏颜色
        setStatusBar(this, R.color.colorWhite);
    }

    /**
     * 设置状态栏颜色.
     *
     * @param activity the activity
     * @param color    颜色值
     */
    @TargetApi(23)
    public void setStatusBar(Activity activity, int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // SDK23
            Window win = activity.getWindow();
            win.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            win.setStatusBarColor(getResources().getColor(color,null));
        }
    }

    /**
     * 隐藏返回按钮.
     */
    public void hideBackBtn() {
        findViewById(R.id.fl_back).setVisibility(View.GONE);
    }

    /**
     * 设置标题栏信息.
     *
     * @param param 参数【0~n个】
     */
    protected void setTitleBar(String... param) {

        View backView = findViewById(R.id.fl_back);
        if (null != backView) {
            backView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onTitleBarLeftClick();
                }
            });
        }

        if (param == null) {
            return;
        }

        TextView title = (TextView) findViewById(R.id.tv_title);
        if (null != title) {
            title.setText(param[0]);
        }

        View rightBtn = findViewById(R.id.fl_attach_menu);
        if (null != rightBtn) {
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onTitleBarRightClick();
                }
            });
        }

        TextView rightText = (TextView) findViewById(R.id.tv_attach_menu);
        if (null == rightText) {
            return;
        }

        if (param.length >= 2) {
            rightText.setText(param[1]);
        }
    }

    @Override
    public void onTitleBarLeftClick() {
        finish();
    }

    @Override
    public void onTitleBarRightClick() {}
}
