package com.qgrj.uisrnns.Dao;


import com.qgrj.uisrnns.Pojo.CntRouter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CntRouterMapper {
    int deleteByPrimaryKey(Integer routerid);

    int insert(CntRouter record);

    CntRouter selectByPrimaryKey(Integer routerid);

    List<CntRouter> selectAll();

    int updateByPrimaryKey(CntRouter record);

    @Select("select RouterID from cnt_router where IP=#{ip}")
    Integer slectbyipofid( String ip);
}