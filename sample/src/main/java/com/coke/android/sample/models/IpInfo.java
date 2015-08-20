package com.coke.android.sample.models;

import com.coke.base.base.modles.CokeBaseModel;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/23 下午1:58
 * @ Description: //
 */
public class IpInfo extends CokeBaseModel {

    private String ip;
    private String userIP;
    private String connectIP;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getConnectIP() {
        return connectIP;
    }

    public void setConnectIP(String connectIP) {
        this.connectIP = connectIP;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "ip='" + ip + '\'' +
                ", userIP='" + userIP + '\'' +
                ", connectIP='" + connectIP + '\'' +
                '}';
    }
}
