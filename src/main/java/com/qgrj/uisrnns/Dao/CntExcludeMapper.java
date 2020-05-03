package com.qgrj.uisrnns.Dao;


import com.qgrj.uisrnns.Pojo.CntExclude;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
@Mapper
public interface CntExcludeMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(CntExclude record);

    CntExclude selectByPrimaryKey(Integer did);

    List<CntExclude> selectAll();

    int updateByPrimaryKey(CntExclude record);

    Date selectByUkeyofDate(String ukey);

    @Select("select 1 from cnt_exclude where UKEY=#{ukey} limit 1")
    Integer selectBykey(String ukey);
}