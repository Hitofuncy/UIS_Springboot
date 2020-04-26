package com.qgrj.uisrnns.Service;

import com.qgrj.uisrnns.Pojo.CntBell;

import java.util.List;

public interface CntBellService {
    int deleteByPrimaryKey(Integer lh);

    int insert(CntBell record);

    CntBell selectByPrimaryKey(Integer lh);

    List<CntBell> selectAll();

    int updateByPrimaryKey(CntBell record);

    String selectByidofplace(Integer id);
}
