package com.coke.bean.db.base;

import android.app.Application;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @ Author Wan,Faxue
 * @ Date 15/8/20 下午3:43
 * @ Description //
 */
public class DBApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库
        FlowManager.init(this);
    }
}
