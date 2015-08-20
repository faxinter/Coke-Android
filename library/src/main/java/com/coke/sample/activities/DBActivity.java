package com.coke.sample.activities;

import android.os.Bundle;

import com.coke.base.CokeBaseActivity;
import com.coke.base.Logger;
import com.coke.sample.R;
import com.coke.sample.models.db.TestModel;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class DBActivity extends CokeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        ButterKnife.bind(this);
    }

    @DebugLog
    @OnClick(R.id.db_btn)
    public void onDbBtnClick() {
        TestModel model = new TestModel();
        model.address = "123456";
        model.name = "ww";
        model.city = "bj";
        model.save();
    }

    @DebugLog
    @OnClick(R.id.db_del_btn)
    public void onDbDelBtnClick() {
        Delete.table(TestModel.class);
    }

    @DebugLog
    @OnClick(R.id.db_list_btn)
    public void onDbListBtnClick() {
        Collection<TestModel> models = new Select().from(TestModel.class).queryList();
        for (TestModel model : models) {
            Logger.d("model:" + model.toString());
        }
    }

    @DebugLog
    @OnClick(R.id.db_query_btn)
    public void onDbQueryBtnClick() {
        List<TestModel> list = new Select("name").from(TestModel.class).
                where(Condition.column("name").is("ww")).queryList();

        for (TestModel model : list) {
            Logger.d("model:" + model.toString());
        }
    }

    @DebugLog
    @OnClick(R.id.db_query_btn)
    public void onDbUpdateBtnClick() {
        TestModel model = new TestModel();
        model.name = "aa";
        model.city = "jn";
        model.save();

    }
}
