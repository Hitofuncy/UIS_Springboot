package com.qgrj.uisrnns.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
public class TCPUtil {
    private String ip;   //服务器端ip地址
    private int port;        //端口号

    public TCPUtil(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public TCPUtil() {
    }

    public void run(String content) throws IOException {
        run(ip,port,content);
    }
    public void run(String ip,int port,String content) throws IOException {
        Socket sck=new Socket(ip,port);
        //2.传输内容
        //有参数决定
        //String content="audio";
        byte[] bstream=content.getBytes("GBK");  //转化为字节流
        OutputStream os=sck.getOutputStream();   //输出流
        os.write(bstream);
        //3.关闭连接
        sck.close();
    }


}
