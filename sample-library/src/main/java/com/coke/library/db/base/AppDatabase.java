package com.coke.library.db.base;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @ Author Wan,Faxue
 * @ Date 15/7/1 下午3:43
 * @ Description // 定义数据版本和名称
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "app";

    public static final int VERSION = 1;
}