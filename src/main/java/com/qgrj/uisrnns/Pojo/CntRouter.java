package com.qgrj.uisrnns.Pojo;

/**
 * 中心表
 */
public class CntRouter {
    private Integer routerid;

    private String ip;

    public Integer getRouterid() {
        return routerid;
    }

    public void setRouterid(Integer routerid) {
        this.routerid = routerid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}