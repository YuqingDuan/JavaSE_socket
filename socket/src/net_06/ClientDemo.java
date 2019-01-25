package net_06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP协议发送数据：
 * A:创建发送端的Socket对象
 * 		这一步如果成功，就说明连接已经建立成功了。
 * B:获取输出流，写数据
 * C:释放资源
 *
 * 连接被拒绝。TCP协议一定要先看服务器。
 * java.net.ConnectException: Connection refused: connect
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端的Socket对象
        // Socket(InetAddress address, int port)
        // Socket(String host, int port)
        Socket s = new Socket("192.168.154.1", 8888);

        // 获取输出流，写数据
        // public OutputStream getOutputStream()
        OutputStream os = s.getOutputStream();
        os.write("hello, tcp!".getBytes());

        // 释放资源
        s.close();
    }
}
