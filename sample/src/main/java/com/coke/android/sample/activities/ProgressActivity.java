package com.coke.android.sample.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.coke.android.sample.R;

public class ProgressActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_activity);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {

            // Make new fragment to show.
            fragment = ProgressFragment.newInstance(null, null);

            getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
        }
    }


}
