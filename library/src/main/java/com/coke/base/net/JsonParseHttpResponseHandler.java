package com.coke.base.net;

import com.bluelinelabs.logansquare.LoganSquare;
import com.coke.base.AppConfig;
import com.coke.base.Logger;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpStatus;

import java.lang.reflect.ParameterizedType;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/21 下午2:15
 * @ Description: // 使用 FastJson 转换网络请求返回结果
 */
abstract class JsonParseHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler {

    //    private Class<JSON_TYPE> mClazz;

    /**
     * Creates a new JsonHttpResponseHandler with default charset "UTF-8"
     */
    public JsonParseHttpResponseHandler() {
        this(DEFAULT_CHARSET);
    }

    /**
     * Creates a new JsonHttpResponseHandler with given string encoding
     *
     * @param encoding result string encoding, see <a href="http://docs.oracle.com/javase/7/docs/api/java/nio/charset/Charset.html">Charset</a>
     */
    public JsonParseHttpResponseHandler(String encoding) {
        super(encoding);
    }

    /**
     * Base abstract method, handling defined generic type
     *
     * @param statusCode      HTTP status line
     * @param headers         response headers
     * @param rawJsonResponse string of response, can be null
     * @param response        response returned by {@link #parseResponse(String, boolean)}
     */
    public abstract void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, JSON_TYPE response);

    /**
     * Base abstract method, handling defined generic type
     *
     * @param statusCode    HTTP status line
     * @param headers       response headers
     * @param throwable     error thrown while processing request
     * @param rawJsonData   raw string data returned if any
     * @param errorResponse response returned by {@link #parseResponse(String, boolean)}
     */
    public abstract void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, JSON_TYPE errorResponse);

    @Override
    public final void onSuccess(final int statusCode, final Header[] headers, final String responseString) {
        if (AppConfig.DEBUG) {
            Logger.d("==================================");
            Logger.d("status code: " + statusCode);
            for (Header header : headers) {
                Logger.d("header: " + header);
            }
            Logger.d("responseString: " + responseString);
            Logger.d("==================================");
        }

        if (statusCode != HttpStatus.SC_NO_CONTENT) {
            Runnable parser = new Runnable() {
                @Override
                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = parseResponse(responseString, false);
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                onSuccess(statusCode, headers, responseString, jsonResponse);
                            }
                        });
                    } catch (final Throwable t) {
                        Logger.d("parseResponse thrown an problem" + t);
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                onFailure(statusCode, headers, t, responseString, null);
                            }
                        });
                    }
                }
            };
            if (!getUseSynchronousMode()) {
                new Thread(parser).start();
            } else {
                // In synchronous mode everything should be run on one thread
                parser.run();
            }
        } else {
            onSuccess(statusCode, headers, null, null);
        }
    }

    @Override
    public final void onFailure(final int statusCode, final Header[] headers, final String responseString, final Throwable throwable) {
        if (AppConfig.DEBUG) {
            Logger.d("==================================");
            Logger.d("status code: " + statusCode);
            if (null != headers) {
                for (Header header : headers) {
                    Logger.d("header: " + header);
                }
            }
            Logger.d("responseString: " + responseString);
            Logger.d("throwable: " + throwable.getMessage());
            Logger.d("==================================");
        }
        if (responseString != null) {
            Runnable parser = new Runnable() {
                @Override
                public void run() {
                    try {
                        final JSON_TYPE jsonResponse = parseResponse(responseString, true);
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                onFailure(statusCode, headers, throwable, responseString, jsonResponse);
                            }
                        });
                    } catch (Throwable t) {
                        Logger.d("parseResponse thrown an problem" + t);
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                onFailure(statusCode, headers, throwable, responseString, null);
                            }
                        });
                    }
                }
            };
            if (!getUseSynchronousMode()) {
                new Thread(parser).start();
            } else {
                // In synchronous mode everything should be run on one thread
                parser.run();
            }
        } else {
            onFailure(statusCode, headers, throwable, null, null);
        }
    }

    /**
     * Should return deserialized instance of generic type, may return object for more vague
     * handling
     *
     * @param rawJsonData response string, may be null
     * @param isFailure   indicating if this method is called from onFailure or not
     * @return object of generic type or possibly null if you choose so
     * @throws Throwable allows you to throw anything from within deserializing JSON response
     */
    protected JSON_TYPE parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
        // 方案一  构造方案不传递 class 的方式
        Class<JSON_TYPE> clazz = (Class<JSON_TYPE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return LoganSquare.parse(rawJsonData, clazz);
        // 方案二 通过构造方法传递 clazz
        // return JSON.parseObject(rawJsonData, mClazz);
    }
}
