package com.coke.base.net;

import org.apache.http.Header;

import hugo.weaving.DebugLog;

/**
 * @ Author Wan,Faxue
 * @ Date 15/6/29 下午4:00
 * @ Description // Please Add Annotation
 */
abstract public class HttpResponseHandler<JSON_TYPE>
        extends JsonParseHttpResponseHandler<JSON_TYPE> {

    @Override
    public void onSuccess(int statusCode, Header[] headers,
                          String rawJsonResponse, JSON_TYPE response) {
        onSuccess(statusCode, response);
    }

    @DebugLog
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable,
                          String rawJsonData, JSON_TYPE errorResponse) {
        onFailure(statusCode, throwable, errorResponse);
    }

    abstract public void onSuccess(int statusCode, JSON_TYPE response);

    abstract public void onFailure(int statusCode, Throwable throwable, JSON_TYPE errorResponse);

}
