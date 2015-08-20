package com.coke.android.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coke.android.sample.activities.NetActivity;
import com.coke.android.sample.activities.ProgressActivity;
import com.coke.library.Logger;
import com.coke.base.base.CokeBaseActivity;


public class MainActivity extends CokeBaseActivity {

    private Button mNetButton;
    private Button mPorgressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setFirstActivity(true);
    }

    private void initView() {
        mNetButton = (Button) this.findViewById(R.id.net_button);
        mNetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Logger.d("on click");
                Intent intent = new Intent(MainActivity.this, NetActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        mPorgressButton = (Button) this.findViewById(R.id.progress_btn);
        mPorgressButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Logger.d("on click");
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }




}
