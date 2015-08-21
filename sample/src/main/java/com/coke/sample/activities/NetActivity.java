package com.coke.sample.activities;

import android.os.Bundle;

import com.coke.base.CokeBaseActivity;
import com.coke.base.Logger;
import com.coke.library.models.IpInfo;
import com.coke.base.net.HttpResponseHandler;
import com.coke.library.api.MainApi;
import com.coke.sample.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

public class NetActivity extends CokeBaseActivity {

    private MainApi mApi;
    // 服务器返回错误
    // 服务器返回的json 错误
    // 请求的 url 错误
    // 请求超时
    // 无网络
    // 网络不能上网

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        ButterKnife.bind(this);

        mApi = MainApi.getInstance();
    }

    @DebugLog
    @OnClick(R.id.get_btn)
    public void onGetBtnClick() {

        mApi.testApi(this, new HttpResponseHandler<IpInfo>() {

            @Override
            public void onSuccess(int statusCode, IpInfo response) {
                Logger.d("on success status code: " + statusCode);
                Logger.d("response: " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, IpInfo errorResponse) {

            }
        });
    }

    @DebugLog
    @OnClick(R.id.err_url_btn)
    public void onErrorUrlBtnClick() {

        mApi.testErrorApi(this, new HttpResponseHandler<IpInfo>() {

            @Override
            public void onSuccess(int statusCode, IpInfo response) {
                Logger.d("on success status code: " + statusCode);
                Logger.d("response: " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, IpInfo errorResponse) {

                Logger.e(throwable.getMessage());

            }
        });
    }

    @DebugLog
    @OnClick(R.id.timeout_btn)
    public void onTimeOutBtnClick() {

    }
}
