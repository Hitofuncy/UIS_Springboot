package com.qgrj.uisrnns.Dao;

import com.qgrj.uisrnns.Pojo.CntCallbell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CntCallbellMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(CntCallbell record);

    CntCallbell selectByPrimaryKey(Integer cid);

    List<CntCallbell> selectAll();

    int updateByPrimaryKey(CntCallbell record);

    List<String> selectbyKeyofIps(String ukey);
}