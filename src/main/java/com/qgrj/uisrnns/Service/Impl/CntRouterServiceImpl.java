package com.qgrj.uisrnns.Service.Impl;

import com.qgrj.uisrnns.Dao.CntRouterMapper;
import com.qgrj.uisrnns.Pojo.CntRouter;
import com.qgrj.uisrnns.Service.CntRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CntRouterServiceImpl implements CntRouterService {
    @Autowired
    private CntRouterMapper cntRouterMapper;
    @Override
    public int deleteByPrimaryKey(Integer routerid) {
        return cntRouterMapper.deleteByPrimaryKey(routerid);
    }

    @Override
    public int insert(CntRouter record) {
        return cntRouterMapper.insert(record);
    }

    @Override
    public CntRouter selectByPrimaryKey(Integer routerid) {
        return cntRouterMapper.selectByPrimaryKey(routerid);
    }

    @Override
    public List<CntRouter> selectAll() {
        return cntRouterMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CntRouter record) {
        return cntRouterMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer slectbyipofid(String ip) {
        return cntRouterMapper.slectbyipofid(ip);
    }
}
