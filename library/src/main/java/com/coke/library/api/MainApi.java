package com.coke.library.api;

import android.content.Context;

import com.coke.base.net.CokeBaseApi;
import com.coke.base.net.HttpResponseHandler;

/**
 * @ Author Wan,Faxue
 * @ Date 15/3/24 上午11:23
 * @ Description: //TODO(用一句话描述该文件做什么)
 */
public class MainApi extends ConstantApi {

    private static MainApi mInstance = null;

    private MainApi() {
    }

    public static MainApi getInstance() {
        if (null == mInstance) {
            mInstance = new MainApi();
        }
        return mInstance;
    }

    //----------------main api---------------

    public <T> void testApi(Context context, HttpResponseHandler<T> responseHandler) {
        CokeBaseApi.get(context, "http://tv.baidu.com/rest/2.0/device/getip", null, responseHandler);
    }

    public <T> void testErrorApi(Context context, HttpResponseHandler<T> responseHandler) {
        CokeBaseApi.get(context, "http://tv.baidu.com/rest/2.0/device//agetip", null, responseHandler);
    }
}
