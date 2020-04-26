package com.qgrj.uisrnns.Service;

import com.qgrj.uisrnns.Pojo.CntCallbell;

import java.util.List;

public interface CntCallBellService {
    int deleteByPrimaryKey(Integer cid);

    int insert(CntCallbell record);

    CntCallbell selectByPrimaryKey(Integer cid);

    List<CntCallbell> selectAll();

    int updateByPrimaryKey(CntCallbell record);

    List<String> selectbyKeyofIps(String ukey);
}
