package com.coke.bean.db.base;

import com.coke.bean.db.base.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @ Author Wan,Faxue
 * @ Date 15/7/1 下午3:45
 * @ Description //
 */

@Table(databaseName = AppDatabase.NAME)
public class DBBaseModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    long id;

}
