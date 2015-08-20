package com.coke.base.ui.loadview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.coke.sample.R;

/**
 * 自定义要切换的布局，通过IVaryViewHelper实现真正的切换<br>
 * 使用者可以根据自己的需求，使用自己定义的布局样式
 */
public class BaseLoadViewHelper {

    private ILoadView helper;

    public BaseLoadViewHelper(View view) {
        this(new LoadViewCore(view));
    }

    public BaseLoadViewHelper(ILoadView helper) {
        super();
        this.helper = helper;
    }

    /**
     * 错误界面
     */
    public void showError(String errorText, String buttonText, OnClickListener onClickListener) {
        View layout = helper.inflate(R.layout.base_loadview_error);
        TextView textView = (TextView) layout.findViewById(R.id.textView1);
        textView.setText(errorText);
        Button button = (Button) layout.findViewById(R.id.button1);
        button.setText(buttonText);
        button.setOnClickListener(onClickListener);
        helper.showLayout(layout);
    }

    /**
     * 网络请求 重试
     */
    public void showRetry() {

    }

    /**
     * 显示空界面
     */
    public void showEmpty(String errorText, String buttonText, OnClickListener onClickListener) {
        View layout = helper.inflate(R.layout.base_loadview_empty);
        TextView textView = (TextView) layout.findViewById(R.id.textView1);
        textView.setText(errorText);
        Button button = (Button) layout.findViewById(R.id.button1);
        button.setText(buttonText);
        button.setOnClickListener(onClickListener);
        helper.showLayout(layout);
    }

    /**
     * 加载界面
     */
    public void showLoading(String loadText) {
        View layout = helper.inflate(R.layout.base_loadview_ing);
        TextView textView = (TextView) layout.findViewById(R.id.textView1);
        textView.setText(loadText);
        helper.showLayout(layout);
    }

    public void restore() {
        helper.restoreView();
    }
}
