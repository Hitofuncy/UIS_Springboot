package com.qgrj.uisrnns.Controller;

import com.qgrj.uisrnns.Pojo.CntExclude;
import com.qgrj.uisrnns.Service.CntExcludeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping(path="/exclude")
@ResponseBody
public class CntExcludeController {

    @Autowired
    private CntExcludeService cntExcludeServiceImpl;

    @GetMapping(path="/delete")
    public int deleteByPrimaryKey(Integer did){
        return cntExcludeServiceImpl.deleteByPrimaryKey(did);
    }

    @GetMapping(path="/insert")
    public int insert(CntExclude record){
        if (record.getDid()==null||cntExcludeServiceImpl.selectByPrimaryKey(record.getDid())==null)
            return 0;
        return cntExcludeServiceImpl.insert(record);
    }

    @GetMapping(path="/select")
    public CntExclude selectByPrimaryKey(Integer did){
        return cntExcludeServiceImpl.selectByPrimaryKey(did);
    }

    @GetMapping(path="/all")
    public List<CntExclude> selectAll(){
        return cntExcludeServiceImpl.selectAll();
    }

    @GetMapping(path="/update")
    public int updateByPrimaryKey(CntExclude record){
        return cntExcludeServiceImpl.updateByPrimaryKey(record);
    }
}
