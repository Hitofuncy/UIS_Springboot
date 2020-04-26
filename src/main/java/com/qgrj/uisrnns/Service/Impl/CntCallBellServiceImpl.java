package com.qgrj.uisrnns.Service.Impl;

import com.qgrj.uisrnns.Dao.CntCallbellMapper;
import com.qgrj.uisrnns.Pojo.CntCallbell;
import com.qgrj.uisrnns.Service.CntCallBellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CntCallBellServiceImpl implements CntCallBellService {
    @Autowired
    private CntCallbellMapper cntCallbellMapper;
    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return cntCallbellMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(CntCallbell record) {
        return cntCallbellMapper.insert(record);
    }

    @Override
    public CntCallbell selectByPrimaryKey(Integer cid) {
        return cntCallbellMapper.selectByPrimaryKey(cid);
    }

    @Override
    public List<CntCallbell> selectAll() {
        return cntCallbellMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(CntCallbell record) {
        return cntCallbellMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> selectbyKeyofIps(String ukey) {
        return cntCallbellMapper.selectbyKeyofIps(ukey);
    }
}
