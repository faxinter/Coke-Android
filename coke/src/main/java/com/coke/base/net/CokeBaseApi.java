package com.coke.base.net;

import android.content.Context;

import com.coke.base.AppConfig;
import com.coke.base.Logger;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/20 下午1:59
 * @ Description: // 网络请求封装父类
 */
public class CokeBaseApi {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public enum RequestType {
        Get, Post, Put, Delete
    }

    public static <T> void get(Context context, String url, RequestParams params, JsonParseHttpResponseHandler<T> responseHandler) {
        sendRequest(context, RequestType.Get, url, params, responseHandler);
    }

    public static <T> void post(Context context, String url, RequestParams params, JsonParseHttpResponseHandler<T> responseHandler) {
        sendRequest(context, RequestType.Post, url, params, responseHandler);
    }

    public static void cancelRequests() {
        client.cancelAllRequests(true);
    }

    private static <T> void sendRequest(Context context, RequestType type, String url, RequestParams params, JsonParseHttpResponseHandler<T> responseHandler) {
        if (AppConfig.DEBUG) {
            Logger.d("==================================");
            Logger.d("User-Agent: " + UserAgentUtil.get(context));
            Logger.d("url: " + url);
            Logger.d("request type: " + type.toString());
            Logger.d("request params: " + (params == null ? "" : params.toString()));
            Logger.d("==================================");
        }

        // debug版本不缓存
        if (AppConfig.HTTP_JSON_CACHE || AppConfig.DEBUG) {
            //TODO 添加一些额外的功能,例如 json 文件的 Cache
        }

        client.setTimeout(5);
        client.addHeader("User-Agent", UserAgentUtil.get(context));

        switch (type) {
            case Get:
                client.get(context, url, null, params, responseHandler);
                break;

            case Post:
                client.post(url, params, responseHandler);
                break;
        }
    }

}
