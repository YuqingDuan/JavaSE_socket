package net_09;

import java.io.*;
import java.net.Socket;

/*
 * 客户端键盘录入，服务器输出文本文件
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("192.168.154.1", 23456);

        // 键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 把通道内的流给包装一下
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            // 键盘录入数据要自定义结束标记
            if ("over".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        // 释放资源
        // bw.close();
        // br.close();
        s.close();
    }
}