package com.coke.base;

import android.support.v4.app.Fragment;

import com.coke.base.analytics.AppAnalytics;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/19 下午4:08
 * @ Description: // 父
 */
public class CokeBaseFragment extends Fragment {

    private final String mTag = this.getClass().getSimpleName();

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        AppAnalytics.onPageStart(mTag);
    }

    @Override
    public void onPause() {
        super.onPause();
        AppAnalytics.onPageEnd(mTag);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
