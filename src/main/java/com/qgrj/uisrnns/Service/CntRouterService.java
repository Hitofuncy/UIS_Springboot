package com.qgrj.uisrnns.Service;

import com.qgrj.uisrnns.Pojo.CntRouter;

import java.util.List;

public interface CntRouterService {
    int deleteByPrimaryKey(Integer routerid);

    int insert(CntRouter record);

    CntRouter selectByPrimaryKey(Integer routerid);

    List<CntRouter> selectAll();

    int updateByPrimaryKey(CntRouter record);

    Integer slectbyipofid( String ip);
}
