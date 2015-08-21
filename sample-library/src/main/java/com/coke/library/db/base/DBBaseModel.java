package com.coke.library.db.base;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @ Author Wan,Faxue
 * @ Date 15/7/1 下午3:45
 * @ Description // 数据库 model 父类，该类继承自 DBFlow 的 BaseModel，so 该类的之类无需再继续
 */

public class DBBaseModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public long id;

}
