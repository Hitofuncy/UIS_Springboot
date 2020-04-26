package com.qgrj.uisrnns.Pojo;

/**
 * 铃表{
 *     lh:铃号
 *     location：地点      例如：1-a
 *     routerid:路由器号    例如：001
 * }
 *
 */
public class CntBell {
    private Integer lh;

    private String location;

    private Integer routerid;

    public Integer getLh() {
        return lh;
    }

    public void setLh(Integer lh) {
        this.lh = lh;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getRouterid() {
        return routerid;
    }

    public void setRouterid(Integer routerid) {
        this.routerid = routerid;
    }
}