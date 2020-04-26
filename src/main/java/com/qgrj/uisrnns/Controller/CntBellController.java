package com.qgrj.uisrnns.Controller;

import com.qgrj.uisrnns.Pojo.CntBell;
import com.qgrj.uisrnns.Service.CntBellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/bell/")
@ResponseBody
public class CntBellController {
    @Autowired
    private CntBellService cntBellServiceImpl;

    @GetMapping(path="/delete")
    public int deleteByPrimaryKey(Integer lh){
        return cntBellServiceImpl.deleteByPrimaryKey(lh);
    }

    @GetMapping(path="/insert")
    int insert(CntBell record){
        cntBellServiceImpl.insert(record);
        return record.getLh();
    }

    @GetMapping(path="/select")
    CntBell selectByPrimaryKey(Integer lh){
        return cntBellServiceImpl.selectByPrimaryKey(lh);
    }

    @GetMapping(path="/all")
    List<CntBell> selectAll(){
        return cntBellServiceImpl.selectAll();
    }

    @GetMapping(path="/update")
    int updateByPrimaryKey(CntBell record){
        return cntBellServiceImpl.updateByPrimaryKey(record);
    }
}
