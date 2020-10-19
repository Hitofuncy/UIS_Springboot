package com.qgrj.uisrnns.Controller.APK;

import com.qgrj.uisrnns.Dao.CntDatatablesMapper;
import com.qgrj.uisrnns.Pojo.CntDatatables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppServiceController {

    @Autowired
    CntDatatablesMapper cntDatatablesMapper;

    @GetMapping("/test")
    public String test(){ return "test";}

    // 获取今天总流量
    @GetMapping("/getTodayNum")
    public Integer getTodayNum(){ return cntDatatablesMapper.getTodayNum();}

    // 获取昨天总流量
    @GetMapping("/getYesterdayNum")
    public Integer getYesterdayNum(){ return cntDatatablesMapper.getYesterdayNum();}
    // 流量纪录
    @GetMapping("/flowRecord")
    public Integer flowRecord(){ return cntDatatablesMapper.flowRecord();}
    // 近7天的查询总数据
    @GetMapping("/getLastSevenDayInfo")
    public List<CntDatatables> getLastSevenDayInfo(){ return cntDatatablesMapper.getLastSevenDayInfo();}

    @GetMapping("/getLastSevenDayInfoById")
    public List<CntDatatables> getLastSevenDayInfoById(@RequestParam("id") String id){ return cntDatatablesMapper.getLastSevenDayInfoById(id);}

}
