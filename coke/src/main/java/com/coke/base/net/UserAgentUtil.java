package com.coke.base.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import com.coke.base.utils.AppUtils;

import java.util.Locale;

/**
 * Utility class to generate and cache a User-Agent header for HTTP requests.
 */
public final class UserAgentUtil {

    private static String sUserAgent;

    private UserAgentUtil() {
        // No public constructor
    }

    /**
     * Get the User-Agent with the following syntax:
     * <p/>
     * Mozilla/5.0 (Linux; U; Android {Build.VERSION.RELEASE}; {locale.toString()}[; {Build.MODEL}]
     * [; Build/{Build.ID}]) {getPackageName()}/{getVersionCode()}
     *
     * @param context The context to use to generate the User-Agent.
     * @return The User-Agent.
     */
    public synchronized static String get(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        if (sUserAgent == null) {
            sUserAgent = generate(context);
        }
        return sUserAgent;
    }

    private static String generate(Context context) {
        StringBuilder sb = new StringBuilder();

        sb.append("(Android");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());

        String model = Build.MODEL;
        if (!TextUtils.isEmpty(model)) {
            sb.append("; ");
            sb.append(model);
        }

        String buildId = Build.ID;
        if (!TextUtils.isEmpty(buildId)) {
            sb.append("; Build/");
            sb.append(buildId);
        }
        sb.append(") ");

        sb.append(context.getPackageName());
        sb.append("/");
        sb.append(AppUtils.getVersionCode(context));
        sb.append("/");
        sb.append(AppUtils.getChannelName(context));

        return sb.toString();
    }
}
