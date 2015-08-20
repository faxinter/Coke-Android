package com.coke.library.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.coke.base.modles.CokeBaseModel;

/**
 * @ Author Wan,Faxue
 * @ Date 15/1/23 下午1:58
 * @ Description: //
 */
@JsonObject
public class IpInfo extends CokeBaseModel {
    @JsonField
    public String ip;
    @JsonField
    public String userIP;
    @JsonField
    public String connectIP;

    @Override
    public String toString() {
        return "IpInfo{" +
                "ip='" + ip + '\'' +
                ", userIP='" + userIP + '\'' +
                ", connectIP='" + connectIP + '\'' +
                '}';
    }
}
