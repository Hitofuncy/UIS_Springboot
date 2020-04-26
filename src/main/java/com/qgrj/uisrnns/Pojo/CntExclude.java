package com.qgrj.uisrnns.Pojo;

import java.util.Date;

/**
 * 排除表
 */
public class CntExclude {
    private Integer did;

    private String ukey;

    private Date date;

    private Integer ifoperation;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey == null ? null : ukey.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIfoperation() {
        return ifoperation;
    }

    public void setIfoperation(Integer ifoperation) {
        this.ifoperation = ifoperation;
    }
}