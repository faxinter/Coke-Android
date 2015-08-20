package com.coke.android.sample.api;

import com.coke.base.net.CokeBaseApi;
import com.coke.base.net.JsonParseHttpResponseHandler;

/**
 * @ Author Wan,Faxue
 * @ Date 15/3/24 上午11:23
 * @ Description: //TODO(用一句话描述该文件做什么)
 */
public class MainApi extends AbsApi {

    private static MainApi mInstance = null;

    private MainApi() {
    }

    static MainApi getInstance() {
        if (null == mInstance) {
            mInstance = new MainApi();
        }
        return mInstance;
    }

    //----------------main api---------------

    public <T> void testApi(JsonParseHttpResponseHandler<T> responseHandler) {
        CokeBaseApi.get("http://tv.baidu.com/rest/2.0/device/getip", null, responseHandler);
    }
}
