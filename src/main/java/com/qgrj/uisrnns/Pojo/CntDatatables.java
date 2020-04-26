package com.qgrj.uisrnns.Pojo;

import java.util.Date;

/**
 * 统计数据表：{
 *     uid
 *     location
 *     date
 *     peoplenum
 * }
 */
public class CntDatatables {
    private Integer uid;

    private String location;

    private Date date;

    private Integer peoplenum;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(Integer peoplenum) {
        this.peoplenum = peoplenum;
    }
}