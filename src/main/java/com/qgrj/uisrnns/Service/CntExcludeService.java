package com.qgrj.uisrnns.Service;

import com.qgrj.uisrnns.Pojo.CntExclude;

import java.util.Date;
import java.util.List;

public interface CntExcludeService {
    int deleteByPrimaryKey(Integer did);

    int insert(CntExclude record);

    CntExclude selectByPrimaryKey(Integer did);

    List<CntExclude> selectAll();

    int updateByPrimaryKey(CntExclude record);

    Date selectByUkeyofDate(String ukey);
}
