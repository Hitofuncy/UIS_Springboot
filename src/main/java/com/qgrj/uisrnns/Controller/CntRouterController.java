package com.qgrj.uisrnns.Controller;

import com.qgrj.uisrnns.Pojo.CntRouter;
import com.qgrj.uisrnns.Service.CntRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/router")
@ResponseBody
public class CntRouterController {

    @Autowired
    private CntRouterService cntRouterServiceimpl;

    @GetMapping(path="/delete")
    public int deleteByPrimaryKey(Integer routerid){
        return cntRouterServiceimpl.deleteByPrimaryKey(routerid);
    }

    @GetMapping(path="/insert")
    public int insert(CntRouter record){
        if (record.getRouterid()==null||cntRouterServiceimpl.selectByPrimaryKey(record.getRouterid())==null)
            return 0;
        return cntRouterServiceimpl.insert(record);
    }

    @GetMapping(path="/select")
    public CntRouter selectByPrimaryKey(Integer routerid){
        return cntRouterServiceimpl.selectByPrimaryKey(routerid);
    }

    @GetMapping(path="/all")
    public List<CntRouter> selectAll(){
        return cntRouterServiceimpl.selectAll();
    }

    @GetMapping(path="/update")
    public int updateByPrimaryKey(CntRouter record){
        return cntRouterServiceimpl.updateByPrimaryKey(record);
    }
}
