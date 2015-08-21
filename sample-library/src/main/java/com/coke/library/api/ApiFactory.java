package com.coke.library.api;

/**
 * @ Author Wan,Faxue
 * @ Date 15/3/24 上午11:24
 * @ Description: // 获取 api 接口类
 */
public class ApiFactory {

    public static final int API_MAIN = 1;

    public static <T extends ConstantApi> T getApi(int flag) {
        ConstantApi resultApi = null;

        switch (flag) {
            case API_MAIN:
                resultApi = MainApi.getInstance();
                break;
        }

        return (T) resultApi;
    }
}
