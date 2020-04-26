package com.qgrj.uisrnns.Service.Impl;

import com.qgrj.uisrnns.Dao.CntDatatablesMapper;
import com.qgrj.uisrnns.Pojo.CntDatatables;
import com.qgrj.uisrnns.Service.CntDatatablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CntDatatablesServiceImpl implements CntDatatablesService {

    @Autowired
    private CntDatatablesMapper cntDatatablesMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return cntDatatablesMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(CntDatatables record) {
        return cntDatatablesMapper.insert(record);
    }

    @Override
    public CntDatatables selectByPrimaryKey(Integer uid) {
        return cntDatatablesMapper.selectByPrimaryKey(uid);
    }

    @Override
    public List<CntDatatables> selectAll() {
        return cntDatatablesMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CntDatatables record) {
        return cntDatatablesMapper.updateByPrimaryKey(record);
    }
}
