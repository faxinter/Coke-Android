package com.coke.sample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import com.coke.sample.R;

public class ProgressActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_activity);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {

            // Make new fragment to show.
//            fragment = ProgressFragment.newInstance(null, null);

            getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }


}
