package com.qgrj.uisrnns.Service.Impl;

import com.qgrj.uisrnns.Dao.CntBellMapper;
import com.qgrj.uisrnns.Dao.CntDatatablesMapper;
import com.qgrj.uisrnns.Pojo.CntBell;
import com.qgrj.uisrnns.Pojo.CntDatatables;
import com.qgrj.uisrnns.Service.CntBellService;
import com.qgrj.uisrnns.Service.CntDatatablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CntBellServiceImpl implements CntBellService {
    @Autowired
    private CntBellMapper cntBellMapper;

    @Override
    public int deleteByPrimaryKey(Integer lh) {
        return cntBellMapper.deleteByPrimaryKey(lh);
    }

    @Override
    public int insert(CntBell record) {
        return cntBellMapper.insert(record);
    }

    @Override
    public CntBell selectByPrimaryKey(Integer lh) {
        return cntBellMapper.selectByPrimaryKey(lh);
    }

    @Override
    public List<CntBell> selectAll() {
        return cntBellMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CntBell record) {
        return cntBellMapper.updateByPrimaryKey(record);
    }

    @Override
    public String selectByidofplace(Integer id) {
        return cntBellMapper.selectByidofplace(id);
    }
}
