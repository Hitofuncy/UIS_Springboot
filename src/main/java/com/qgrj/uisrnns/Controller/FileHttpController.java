package com.qgrj.uisrnns.Controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/api")
public class FileHttpController {

    private static final long serialVersionUID = -5865227624891447594L;
    @RequestMapping(consumes = "multipart/form-data",value ="file/receive",method = RequestMethod.POST)
    @ResponseBody
    public  void receive(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String ip = request.getRemoteAddr();
        ip = ip.replace(".","-");
        System.out.println(ip);

        JSONObject jsonObject = new JSONObject();
        boolean success = false;

        // 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) { // 修改程序BETA
            // 将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                String filenn = file.getOriginalFilename().split("[.]")[1];
                if(!filenn.equals("m4a")) continue;
                if (file != null) {
                    //String originalFilename = file.getOriginalFilename();
                    String originalFilename = ip + ".m4a";
                    // 定义绝对路径
                    String localPath = "d:/test/";
                    File path = new File(localPath);
                    // 文件夹不存在 则创建文件夹
                    if (!path.exists()) {
                        path.mkdirs();
                    }
                    String filepath = localPath +File.separator+ originalFilename;
                    File file1 = new File(filepath);
                    if(file1.exists()){
                        file1.delete();
                    }
                    // 文件数据存储起来
                    file.transferTo(file1);
                    success = true;
                }
            }

        }
        jsonObject.put("success",success);
        response.getWriter().println(jsonObject.toString());
    }
}
