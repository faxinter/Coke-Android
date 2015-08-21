package com.coke.base;

import android.os.Bundle;
import android.support.v7.app .AppCompatActivity;
import com.coke.base.analytics.AppAnalytics;
import com.coke.base.net.CokeBaseApi;
import com.umeng.analytics.MobclickAgent;
import butterknife.ButterKnife;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/19 下午4:06
 * @ Description: // 父
 */
public class CokeBaseActivity extends AppCompatActivity {

    private static boolean INITED = false;  // 用于程序入口

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUmeng();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppAnalytics.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppAnalytics.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 取消当前 activity 的网络请求
        CokeBaseApi.cancelRequests();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置是否是入口 Activity,
     *
     * @param flag true or false
     */
//    protected void setFirstActivity(boolean flag) {
//        if (flag) {
//            initUmeng();
//        }
//    }

    /**
     * 初始化 友盟统计
     */
    private void initUmeng() {
        if (INITED) return; // 只初始化一次
        Logger.i("初始化友盟统计...");
        if (AppConfig.DEBUG) {
            MobclickAgent.setDebugMode(true);
        }
        MobclickAgent.updateOnlineConfig(this);

        initUmengUpdate();
        INITED = true;
    }

    /**
     * 初始化 友盟 app 更新
     */
    private void initUmengUpdate() {
//        UmengUpdateAgent.update(this);
    }
}
