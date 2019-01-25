package net_15;

import java.io.*;
import java.net.Socket;

public class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            // 封装通道内的流
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // 封装文本文件并防止名称冲突
            String newFileName = System.currentTimeMillis() + ".txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFileName));

            String line = null;
            while ((line = br.readLine()) != null) {// 阻塞
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
