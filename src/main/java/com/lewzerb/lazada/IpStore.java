package com.lewzerb.lazada;

public interface IpStore {

    void loadData();
    /**
     * 根据IP地址获取省份
     */
    String provinceOfIp(String ip);
}
