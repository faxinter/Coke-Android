package com.coke.sample;

import android.content.Intent;
import android.os.Bundle;

import com.coke.base.CokeBaseActivity;
import com.coke.sample.activities.DBActivity;
import com.coke.sample.activities.NetActivity;

import butterknife.OnClick;

public class MainActivity extends CokeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
    }

    @OnClick(R.id.net_btn)
    public void onNetBtnClick() {
        Intent intent = new Intent(this, NetActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.db_btn)
    public void onDbBtnClick() {
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
    }
}
