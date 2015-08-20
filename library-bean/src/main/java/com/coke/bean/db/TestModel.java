package com.coke.bean.db;

import com.coke.bean.db.base.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @ Author Wan,Faxue
 * @ Date 15/7/1 下午3:45
 * @ Description //  用于测试
 */

@Table(databaseName = AppDatabase.NAME)
public class TestModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    long id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "city")
    public String city;

    @Column(name = "state")
    public String state;

    @Column(name = "phone")
    public long phone;

    @Override
    public String toString() {
        return "TestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone=" + phone +
                '}';
    }
}
