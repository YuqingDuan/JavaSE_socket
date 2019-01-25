package net_15;

import java.io.*;
import java.net.Socket;

public class UploadClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("192.168.154.1", 11111);

        // 封装文本文件
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));

        // 封装通道内流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        // Socket提供了一个终止，它会通知服务器你别等了，我没有数据过来了
        s.shutdownOutput();

        // 接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String client = brClient.readLine();// 阻塞
        System.out.println(client);

        // 释放资源
        br.close();
        s.close();
    }
}
