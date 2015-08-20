package com.coke.android.sample.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coke.android.sample.R;
import com.coke.android.sample.api.ApiFactory;
import com.coke.android.sample.api.MainApi;
import com.coke.android.sample.models.IpInfo;
import com.coke.library.Logger;
import com.coke.base.net.JsonParseHttpResponseHandler;

import org.apache.http.Header;

public class NetActivity extends ActionBarActivity {

    Button mGetBtn;
    Button mTimeoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        mGetBtn = (Button)findViewById(R.id.get_btn);
        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("on click");

                MainApi api = ApiFactory.getApi(ApiFactory.API_MAIN);
                api.testApi(new JsonParseHttpResponseHandler<IpInfo>() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, IpInfo response) {
                        Logger.d("on success status code: " + statusCode);
                        Logger.d("headers: " + headers.toString());
                        Logger.d("rawJsonResponse: " + rawJsonResponse);
                        Logger.d("response: " + response.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, IpInfo errorResponse) {
                        Logger.d("on failure");
                    }
                });
            }
        });

        mTimeoutBtn = (Button)findViewById(R.id.timeout_btn);
        mTimeoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("on click");

                MainApi api = ApiFactory.getApi(ApiFactory.API_MAIN);
                api.testApi(new JsonParseHttpResponseHandler<IpInfo>() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, IpInfo response) {
                        Logger.d("on success status code: " + statusCode);
                        Logger.d("headers: " + headers.toString());
                        Logger.d("rawJsonResponse: " + rawJsonResponse);
                        Logger.d("response: " + response.toString());
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, IpInfo errorResponse) {
                        Logger.d("on failure");
                    }
                });
            }
        });
    }


}
