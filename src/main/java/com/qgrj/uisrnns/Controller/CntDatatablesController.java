package com.qgrj.uisrnns.Controller;

import com.qgrj.uisrnns.Pojo.CntDatatables;
import com.qgrj.uisrnns.Service.CntDatatablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path="/datatables")
@ResponseBody
public class CntDatatablesController {

    @Autowired
    private CntDatatablesService cntDatatablesServiceImpl;

    @GetMapping(path="/delete")
    public int deleteByPrimaryKey(Integer uid){
        return cntDatatablesServiceImpl.deleteByPrimaryKey(uid);
    }

    @GetMapping(path="/insert")
    public int insert(CntDatatables record){
        if (record.getUid()==null)
            return 0;
        if (cntDatatablesServiceImpl.selectByPrimaryKey(record.getUid())==null)
            return 0;
        return cntDatatablesServiceImpl.insert(record);
    }

    @GetMapping(path="/select")
    public CntDatatables selectByPrimaryKey(Integer uid){
        return cntDatatablesServiceImpl.selectByPrimaryKey(uid);
    }

    @GetMapping(path="/all")
    public List<CntDatatables> selectAll(){
        return cntDatatablesServiceImpl.selectAll();
    }

    @GetMapping(path="/update")
    public int updateByPrimaryKey(CntDatatables record){
        return cntDatatablesServiceImpl.updateByPrimaryKey(record);
    }

}
