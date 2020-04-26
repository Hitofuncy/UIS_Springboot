package com.qgrj.uisrnns.Controller;

import com.qgrj.uisrnns.Pojo.CntCallbell;
import com.qgrj.uisrnns.Service.CntCallBellService;
import com.qgrj.uisrnns.Service.CntExcludeService;
import com.qgrj.uisrnns.util.TCPUtil;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(path="/action/")
@ResponseBody
public class CntCallBellController { // demo: 127.0.0.1:8080/action/call 传入ip[逗号分隔] msg=call key=xxxxx

    @Autowired
    private CntExcludeService cntExcludeServiceImpl;

    @Autowired
    private CntCallBellService cntCallBellServiceImpl;

    @GetMapping(path="/call")
    public int call(String[] ip,int post,String msg,String key) throws IOException {
        if (!msg.equals("call"))
            return 0;
//        if(key.equals("数据库的内容")== true)
//            return 0;
        TCPUtil tcpUtil=new TCPUtil();
//        Date date = cntExcludeServiceImpl.selectByUkeyofDate(key);
//        if (date==null)
//            return 0;
        for (String aip:ip) {

            CntCallbell cntCallbell = new CntCallbell();
//            cntCallbell.setDate(date);
            cntCallbell.setIp(aip);
            cntCallbell.setUkey(key);
            cntCallBellServiceImpl.insert(cntCallbell);
            tcpUtil.run(aip,post,msg);
        }
        return 1;
    }

    @GetMapping(path="/uncall")
    public int uncall(int post,String key) throws IOException {
        TCPUtil tcpUtil=new TCPUtil();
        List<String> ips = cntCallBellServiceImpl.selectbyKeyofIps(key);
        for (String ip:ips) {
            tcpUtil.run(ip,post,"uncall");
        }
        return 1;
    }
    //audio
    @GetMapping(path="/audio")
    public int audio(String[] args ,String msg,int post) throws IOException {
        TCPUtil tcpUtil=new TCPUtil();
        for (String ip:args) {
            tcpUtil.run(ip,post,"audio");
        }
        return 1;
    }
    // 请求设备发送文件开始

    @GetMapping(path="/savefile")
    public int savefile(String[] ips,int post) throws IOException {
        TCPUtil tcpUtil=new TCPUtil();
        for (String ip:ips) {
            tcpUtil.run(ip,post,"savefile");
        }
        return 1;
    }

    // 请求设备发送文件结束


}
