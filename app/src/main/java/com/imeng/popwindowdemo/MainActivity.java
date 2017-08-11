package com.imeng.popwindowdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt)
    Button mBt;

    @BindView(R.id.rootview)
    ConstraintLayout mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt)
    public void showPopWindow() {
        // TODO: 2016/5/17 构建一个popupwindow的布局
        setWindowBackgroundAlpha(0.5f);

        View popupView = MainActivity.this.getLayoutInflater().inflate(R.layout.popwindowview, null);

        // TODO: 2016/5/17 创建PopupWindow对象，指定宽度和高度
        //PopupWindow window = new PopupWindow(popupView, 400, 600);
        PopupWindow window = new PopupWindow(popupView);
        //window.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        window.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // TODO: 2016/5/17 设置动画
        window.setAnimationStyle(R.style.popup_window_anim);
        // TODO: 2016/5/17 设置背景颜色
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        // TODO: 2016/5/17 设置可以获取焦点
        window.setFocusable(true);
        // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // TODO：更新popupwindow的状态
        window.update();
        // TODO: 2016/5/17 以下拉的方式显示，并且可以设置显示的位置
        //window.showAsDropDown(mBt, 0, 20);
        window.showAtLocation(mRootView, Gravity.CENTER,0, 0);

    }

    /**
     * 控制窗口背景的不透明度
     * */
    private void setWindowBackgroundAlpha(float alpha) {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.alpha = alpha;
        window.setAttributes(layoutParams);
    }
}
