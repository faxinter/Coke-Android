package com.coke.base.analytics;

import android.app.Activity;
import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * @ Title MainActivity.java
 * @ Author Wan,Faxue
 * @ Date 15-1-19 上午11:20
 * @ Description: 应用统计
 */
public class AppAnalytics {

    //友盟统计

    public static void onStart(Activity activity) {

    }

    public static void onResume(Context context) {
        MobclickAgent.onResume(context); //友盟统计
    }

    public static void onPause(Context context) {

        MobclickAgent.onPause(context); //友盟统计
    }

    public static void onStop(Activity activity) {

    }

    public static void onPageStart(String flag) {
        MobclickAgent.onPageStart(flag);
    }

    public static void onPageEnd(String flag) {
        MobclickAgent.onPageEnd(flag);
    }


    /**
     * 次数统计，对外接口
     */
    public static void onEvent(Context context, String eventId) {
        MobclickAgent.onEvent(context, eventId);
    }

    public static void onTimeEventStart(Context context, String event_id, String label) {
    }

    public static void onTimeEventEnd(Context context, String event_id, String label) {
    }
}
