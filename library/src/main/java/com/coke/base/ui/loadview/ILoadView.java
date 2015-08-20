package com.coke.base.ui.loadview;

import android.content.Context;
import android.view.View;

interface ILoadView {

    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract void showLayout(int layoutId);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();

}