package com.qgrj.uisrnns.Service.Impl;

import com.qgrj.uisrnns.Dao.CntDatatablesMapper;
import com.qgrj.uisrnns.Dao.CntExcludeMapper;
import com.qgrj.uisrnns.Pojo.CntExclude;
import com.qgrj.uisrnns.Service.CntExcludeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CntExcludeServiceImpl implements CntExcludeService {
    @Autowired
    private CntExcludeMapper cntExcludeMapper;
    @Override
    public int deleteByPrimaryKey(Integer did) {
        return cntExcludeMapper.deleteByPrimaryKey(did);
    }

    @Override
    public int insert(CntExclude record) {
        return cntExcludeMapper.insert(record);
    }

    @Override
    public CntExclude selectByPrimaryKey(Integer did) {
        return cntExcludeMapper.selectByPrimaryKey(did);
    }

    @Override
    public List<CntExclude> selectAll() {
        return cntExcludeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CntExclude record) {
        return cntExcludeMapper.updateByPrimaryKey(record);
    }

    @Override
    public Date selectByUkeyofDate(String ukey) {
        return cntExcludeMapper.selectByUkeyofDate(ukey);
    }

    @Override
    public Integer selectBykey(String ukey) {
        return cntExcludeMapper.selectBykey(ukey);
    }
}
